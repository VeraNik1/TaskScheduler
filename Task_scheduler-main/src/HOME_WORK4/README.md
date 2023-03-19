## Task scheduler includes:

- **Priority** - levels of task's priority.
- **Task** - class, which includes fields: ID, StartDate, DeadLineDate, Priority, Author, Controller, Description, Date of creation;
- **Employee** - class, which describes person and includes fields: name and position;
- **TaskStorage** - interface, which defines some methods: add a task, delete the task, to get task by ID, to get the task list.
- **CurrentTaskStorage** - class, which implements **TaskStorage** for saving tasks in RAM.
- **TaskExporter** - interface, which defines method for export the current task list to the file.
- **TaskImporter** - interface, which defines method for import a current task list from the file.
- **JsonTaskExporter** - class, which implements interface **TaskExporter** for export the current task list to json-file.
- **XmlTaskExporter** - class, which implements interface **TaskExporter** for export the current task list to xml-file.
- **Menu** - class, which show the main menu of scheduler for task managing. In this class Object TaskManager is created to manage with tasks, 
and then user can see the menu list of possible actions.
- **Search** - class, which defines some searching methods. 
It has menu with 4 searching options: 
1. Searching the task by ID;
2. Searching tasks which have to be done since now to user's chosen date and time;
3. Searching tasks which have their deadline after user's chosen date and time;
4. Searching tasks by priority.
- **ExportChoice** - class, which defines file format for export.
  It has menu with 3 options:
1. to csv;
2. to json;
3. to xml.

PS. I haven't had enough time to make xml- and json-import before the deadline( 
