import pytest
import System
import os
import json
import RestoreData


def restore_data():
    users = RestoreData.users
    courses = RestoreData.courses
    with open('Data/users.json', 'w') as fp:
        json.dump(users, fp)
    with open('Data/courses.json', 'w') as fp:
        json.dump(courses, fp)


@pytest.fixture
def grading_system():
    gradingSystem = System.System()
    gradingSystem.load_data()
    return gradingSystem


# 1
# Tests if the program can handle a wrong username
def test_login(grading_system):
    restore_data()
    grade_system = System.System()
    name, passwd = "asdf", "asdf"
    grade_system.login(name, passwd)
    assert grade_system.usr is not None


# 2
# Tests if the program can handle a unknown name and password
def test_check_password():
    restore_data()
    grade_system = System.System()
    positive_cases = [("cmhbf5", "bestTA"),
                      ("calyam", "#yeet"),
                      ("saab", "boomr345"),
                      ("goggins", "augurrox"),
                      ("yted91", "imoutofpasswordnames"),
                      ("hdjsr7", "pass1234"),
                      ("akend3", "123454321"), ]
    for (name, password) in positive_cases:
        assert grade_system.check_password(name, password) == True
    negative_cases = [("asdfa", "asdfa"),
                      ("", "")]
    for (name, password) in negative_cases:
        assert grade_system.check_password(name, password) == False


# 3
# Student should be not able to change grade. Staff can change grade.
# Tests if the program updates the data to the json file
def test_change_grade():
    restore_data()
    grade_system = System.System()
    prof_name, prof_passwd = "goggins", "augurrox"
    grade_system.login(prof_name, prof_passwd)
    stud_name, stud_course, stud_assign = "yted91", "software_engineering", "assignment2"
    stud_expected_grade = 11
    grade_system.usr.change_grade(stud_name, stud_course, stud_assign, stud_expected_grade)
    with open('Data/users.json', 'r') as fp:
        users = json.load(fp)
    assert users[stud_name]['courses'][stud_course][stud_assign]['grade'] == stud_expected_grade


# 4
# Verify that an assignment is created with the correct due date in the correct course in the database.
def test_create_assignment():
    restore_data()
    grade_system = System.System()
    prof_name, prof_passwd = "goggins", "augurrox"
    grade_system.login(prof_name, prof_passwd)
    t_assign_name, t_due_date, t_course = 'assignment3', '05/29/20', 'comp_sci'
    grade_system.usr.create_assignment(t_assign_name, t_due_date, t_course)
    with open('Data/courses.json', 'r') as fp:
        courses = json.load(fp)
    assert courses[t_course]['assignments'][t_assign_name]['due_date'] == t_due_date


# 5
# Verify that a student will be added to the correct course in the database.
# Tests if the program can add student to a new course
def test_add_student():
    restore_data()
    grade_system = System.System()
    prof_name, prof_passwd = "goggins", "augurrox"
    grade_system.login(prof_name, prof_passwd)
    stud_name, stud_course = 'akend3', 'software_engineering'
    grade_system.usr.add_student(stud_name, stud_course)
    with open('Data/users.json', 'r') as fp:
        users = json.load(fp)
    assert users[stud_name]['courses'][stud_course] == stud_course


# 6
# Verify that the student is dropped from the correct course in the database.
def test_drop_student():
    restore_data()
    grade_system = System.System()
    prof_name, prof_passwd = "goggins", "augurrox"
    grade_system.login(prof_name, prof_passwd)
    stud_name, stud_course = 'akend3', 'comp_sci'
    grade_system.usr.drop_student(stud_name, stud_course)
    with open('Data/users.json', 'r') as fp:
        users = json.load(fp)
    assert stud_course not in users[stud_name]['courses']


# 7
# Verify that the database is updated with the correct assignment, submission,
# submission date and in the correct course.
# Tests if the program can submit assignment correctly
def test_submit_assignment():
    restore_data()
    grade_system = System.System()
    stud_name, stud_passwd = "akend3", "123454321"
    grade_system.login(stud_name, stud_passwd)
    t_course, t_assign_name, t_submission, t_sub_data = \
        'cloud_computing', 'assignment1', 'Blahhhhh', '03/01/20'
    grade_system.usr.submit_assignment(t_course, t_assign_name, t_submission, t_sub_data)
    with open('Data/users.json', 'r') as fp:
        users = json.load(fp)
    assert users[stud_name]['courses'][t_course][t_assign_name]['grade'] == 'N/A'
    assert users[stud_name]['courses'][t_course][t_assign_name]['submission'] == t_submission
    assert users[stud_name]['courses'][t_course][t_assign_name]['submission_date'] == t_sub_data


# 8
# Verify that it will return true if the assignment is on time, and false if the assignment is late.
def test_check_ontime():
    restore_data()
    grade_system = System.System()
    stud_name, stud_passwd = "akend3", "123454321"
    grade_system.login(stud_name, stud_passwd)
    t_sub_date = "2/2/20"
    t_due_date = "3/3/20"
    assert grade_system.usr.check_ontime(t_sub_date, t_due_date) == True


# 9
# Verify the correct grades are returned for the correct user.
def test_check_grades():
    restore_data()
    grade_system = System.System()
    stud_name, stud_passwd = "akend3", "123454321"
    grade_system.login(stud_name, stud_passwd)
    t_course = "comp_sci"
    expected_grade = [['assignment1', 99], ['assignment2', 66]]
    assert grade_system.usr.check_grades(t_course) == expected_grade


# 10
# Verify the correct assignments for the correct course are returned.
def test_view_assignments():
    restore_data()
    grade_system = System.System()
    stud_name, stud_passwd = "akend3", "123454321"
    grade_system.login(stud_name, stud_passwd)
    t_course = "comp_sci"
    expected_assign = [['assignment1', '2/2/20'], ['assignment2', '2/10/20']]
    assert grade_system.usr.view_assignments(t_course) == expected_assign


# 11
# Tests if the program can check the time correctly
def test_check_ontime2():
    restore_data()
    grade_system = System.System()
    stud_name, stud_passwd = "akend3", "123454321"
    grade_system.login(stud_name, stud_passwd)
    t_due_date = "2/2/20"
    t_sub_date = "3/3/20"
    assert grade_system.usr.check_ontime(t_sub_date, t_due_date) == False


# 12
# Tests if the program can handle a course which is not in the databases
def test_check_grades2():
    restore_data()
    grade_system = System.System()
    stud_name, stud_passwd = "akend3", "123454321"
    grade_system.login(stud_name, stud_passwd)
    t_course = "algorithm"
    expected_grade = 0
    assert grade_system.usr.check_grades(t_course) == expected_grade


# 13
# Tests if the program can handle a course which is not in the databases
def test_view_assignments2():
    restore_data()
    grade_system = System.System()
    stud_name, stud_passwd = "akend3", "123454321"
    grade_system.login(stud_name, stud_passwd)
    t_course = "algorithm"
    expected_assign = []
    assert grade_system.usr.view_assignments(t_course) == expected_assign


# 14
# Tests if the program can handle a new course
def test_create_assignment2():
    restore_data()
    grade_system = System.System()
    prof_name, prof_passwd = "goggins", "augurrox"
    grade_system.login(prof_name, prof_passwd)
    t_assign_name, t_due_date, t_course = 'assignment1', '2/2/20', 'algorithm'
    grade_system.usr.create_assignment(t_assign_name, t_due_date, t_course)
    with open('Data/courses.json', 'r') as fp:
        courses = json.load(fp)
    assert courses[t_course]['assignments'][t_assign_name]['due_date'] == t_due_date


# 15
# Tests if the program can handle a wrong course
def test_change_grade2():
    restore_data()
    grade_system = System.System()
    prof_name, prof_passwd = "goggins", "augurrox"
    grade_system.login(prof_name, prof_passwd)
    stud_name, stud_course, stud_assign = "yted91", "algorithm", "assignment1"
    expected_grade = 11
    grade_system.usr.change_grade(stud_name, stud_course, stud_assign, expected_grade)
    with open('Data/users.json', 'r') as fp:
        users = json.load(fp)
    assert users[stud_name]['courses'][stud_course][stud_assign]['grade'] == expected_grade


if __name__ == '__main__':
    pytest.main(os.path.basename(__file__))
