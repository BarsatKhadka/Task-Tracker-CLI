# Task Tracker (https://roadmap.sh/projects/task-tracker - Roadmap Project)

Welcome to **Task Tracker**! This application helps you track, update, delete, and manage tasks easily. Whether you're handling personal to-do lists or managing work tasks, Task Tracker will keep you organized and on track.

This guide will walk you through how to get started and use Task Tracker effectively.

---

## Getting Started

### 1. Clone the Repository

Clone or download the repository to your local machine using the following Git command:

```bash
git clone https://github.com/BarsatKhadka/Task-Tracker-CLI.git
```

## 2. Install Dependencies

Ensure that you have Java installed on your machine. This project uses Java for the backend. Additionally, the project requires the Gson library to parse JSON. If you are using Maven, the required dependency is already set in the pom.xml.

You can check if Java is installed by running:
```
java -version
```
If Java is not installed, download and install it from https://www.oracle.com/java/technologies/downloads/?er=221886

## 3. Run the Application

Once the dependencies are installed, navigate to the project directory and run the main Java class:

```
java -cp . org.TaskTracker.TaskMain
```

## Task Tracker - Command-Line Interface (CLI)

Once the application is running, you can use the following commands to manage your tasks:
### 1. `--h` (Help)

- **Description**: Displays the help page with a list of available commands.
- **Usage**: 

  ```bash
  task-cli --h

### 2.  add

 - **Description**:  Adds a new task with the specified description.
- **Usage**: 

    ```bash
    task-cli add <task description>
    ```

    **Example**:

    task-cli add Finish the report

### 3.  update

 - **Description**:  Updates the description of the task with the specified ID.

- **Usage**: 

    ```bash
    task-cli update <task id> <task description to update>
    ```

    **Example**:

    task-cli update 1 Finish the report by november 11

### 4. delete

 - **Description**:  Deletes the description of the task with the specified ID.

- **Usage**: 

    ```bash
    task-cli delete <task id> 
    ```

    **Example**:

    task-cli delete 1 

### 5. mark-in-progress


 - **Description**:  Marks the task with the specified ID as "in-progress."

- **Usage**: 

    ```bash
    task-cli mark-in-progress <task ID> 

    ```

    **Example**:

    task-cli mark-in-progress 2

### 6. mark done

- **Description**:  Marks the task with the specified ID as "done."

- **Usage**: 

    ```bash
    task-cli mark done <task ID> 

    ```

    **Example**:

    task-cli mark done 2


### 7. list

- **Description**:  Displays tasks based on their status or lists all tasks.

- **Usage**: 

    ```bash
    task-cli list
    task-cli list done
    task-cli list in-progress
    task-cli list todo
    ```

    **Example**:

    ```
    task-cli list
    task-cli list done
    task-cli list in-progress
    task-cli list todo
    ```

### Happy Task Tracking!

Thank you for using Task Tracker! I hope this application helps you stay on top of your tasks.









