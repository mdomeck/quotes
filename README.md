## quotes

- Once you clone the repo...
- run *gradle init --type java-application* in the terminal
 
 #### dependencies
 - This dependency is used by the application.
      
       implementation 'com.google.guava:guava:28.0-jre'
   
 - Use JUnit test framework
       
       testImplementation 'junit:junit:4.12'
 
 - Used to access gson file
   
       implementation 'com.google.code.gson:gson:2.8.6'
       
       
#### functionality

-  Uses the recentquotes.json file to show random popular book quotes.
- Uses GSON to parse the .json file
- returns one quote each time it is run. 