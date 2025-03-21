# FileLineExtractor

**FileLineExtractor** is a lightweight Java utility that recursively scans a specified folder (and all its subdirectories) to extract the first few lines from each file it finds. 
The output is saved to a single text file for easy review and sampling.

---

## Features

- **Recursive file scanning** — Traverses all subdirectories
- **Extracts the first _n_ lines** of each file (default: 5)
- **Outputs results** to a single text file (`sample_output.txt`)
- **Includes file paths** in the output to track where content came from
- Easy to configure and lightweight – no external libraries needed

---

## Usage

### Set your target folder and output file

In `FileLineExtractor.java`, change these lines:

```java
private static final String INPUT_FOLDER = "C:\\"; // <- Replace with your source folder
private static final String OUTPUT_FILE = "sample_output.txt"; // <- Change if desired
