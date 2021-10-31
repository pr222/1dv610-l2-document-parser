# Document Parser
[Example](https://gitlab.lnu.se/1dv610/student/pr222ja/l2#example)

[Class Diagram](https://gitlab.lnu.se/1dv610/student/pr222ja/l2#class-diagram)

[Manage Dependencies](https://gitlab.lnu.se/1dv610/student/pr222ja/l2#manage-depencencies)

## About
This Document Parser lets you parse text into the parser's Document. By calling parse(String input) on the parser it will then try to parse the text into a collection of sentences which may be one of three types of sentences. You can then ask the parser for the Document with the parsed sentences. 

You may use the parse-method several times and the document will contiune to be added with the new sentences for each parse. In case you want to clear out all the sentences from the document you may call the resetDocument-method.

### Formatting
If the input to be parsed has several blank spaces between words, these will be changed to only one blank space in between. All the sentences will have its ending marker without a blank space between the marker and the last word. 

### Error Handling
In case of some invalid input parts or the whole input may not be added to the Document. To catch the errors you may use the parse-method within a try-catch-block.

## Parser Methods
### getParsedDocument()
Returns the Document class object from which you can ask for the current sentences present in the document. As displayed down in the examples.

### resetDocument()
Empties the document from all present sentences.

### parse(String input)
Parses the input adding valid sentences to the document.

## Document Methods
### getAllSentences()
Returns all sentences that are present in the document. You can determine what type of sentence it is by checking the `instance of` of a particular sentence, wether it is `Regular`, `Question` or `Exclamation`.

## Example
### Instantiate the parser
````
 DocumentParser parser = new DocumentParser(); 
````
### Parse some input
````
 String input = "I am regular. But I have something to say! What was it again?";
 
 parser.parse(input);
 ````
### Use the Document
````
// Get the document...
Document doc = parser.getParsedDocument();

// ...And access all sentences
for (Sentence sentence : document.getAllSentences()) {
    System.out.println(sentence.getSentence());         // Prints out the current sentence
}
````

### Reset Document
````
parser.resetDocument();
````

## Class Diagram
![parser-diagram](./images/parser-diagram.png)

## Manage Depencencies
This is an example for how to manage the dependency of [Tokenizer](https://gitlab.lnu.se/1dv610/student/pr222ja/l1). 

You may have another prefered way of handling dependencies, whichever works best for you.

The main focus here is how to add a .jar-file of the Tokenizer in a way that matches the current build.gradle file. You should have some basic knowledge of how to use gradle as potential build steps and such may not be specified here.

### Files and folders
- Create a folder called `libs` in the project root.
- Add the `lab1-1.1-SNAPSHOT.jar`-file to the 'libs' folder.
- If you don't already have the .jar-file, follow the next section to create it, and then add it.

### Creating the jar-file
- Download [Tokenizer](https://gitlab.lnu.se/1dv610/student/pr222ja/l1) to your local computer.
- Open the repository and run the gradle task of publishing to MavenLocal. 
- Find the `.m2`-folder on your local computer and look for the file in `.m2/repository/org/example/lab1/1.1-SNAPSHOT/lab1-1.1-SNAPSHOT.jar`. 
- Now add the created .jar-file to this project's 'libs'-folder.