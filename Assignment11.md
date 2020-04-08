# Code Review Efficiency

Question: What is the number of merged code changes/number of abandoned code change requests?

## Description
When the project uses the code review process, the changes can not be directly carried out, we need to discuss the new code changes / abandoned code. Each of these suggestions is intended to be reviewed by other developers, and anyone may propose improvements until the review is passed. Some source code will be replaced or deleted. You need to know the number of changes to these merged codes to quantify the activeness of the proposer.

## Objectives
Calculate the amount of changes proposed by the project
Learn the activity index of each participant by calculating comments to change the code in the corresponding repository.
Of course, the metrics of the review is not the only metrics to evaluate the degree of activity.

## Implementation
**Aggregators:**
* Count. Total number of changes during the period.

**Parameters:**
* Period of time. Start and finish date of the period. Default: forever.
 Period during which changes are considered.
* Criteria for source code. Algorithm. Default: all files are source code.
 If focused on source code, criteria for deciding whether a file is a part of the source code or not.

### Filters (optional)
TBD

### Visualizations (optional)
TBD

### Tools Providing the Metric (optional)
TBD

### Data Collection Strategies (Optional)
TBD
## References
Blog posts, websites, academic papers, or books that mention the metric and provide more background.
