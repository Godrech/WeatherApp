



Name: Lukojiwa Godrech Lukoji
student number : ST10458246
Github link : https://github.com/Godrech/WeatherApp



Purpose
This is an application that provides the average temperature for the week and also allows users to view detailed information for each day.


 



 
 


example of table data
 


example of inputted data
 


third and last activity
 

second activity
 

error message
 

first activity
 

splash screen
 











































PSUEDOCODE

Start

// Declarations
String[] dayArray
num[] minimumArray
num[] maximumArray
String[] weatherConditionArray
String day
num minimum
num maximum
String weatherCondition
String errorMsg
String cdTitleToSearch
num index

// Initialize arrays
dayArray = []
minimumArray = []
maximumArray = []
weatherConditionArray = []

// Input
display "Enter the day:"
input day
display "Enter the minimum temperature:"
input minimum
display "Enter the maximum temperature:"
input maximum
display "Enter the weather condition:"
input weatherCondition

// Process for saving inputted data when pressing the save button
if day is not empty AND minimum is not empty AND maximum is not empty AND weatherCondition is not empty
    dayArray.append(day)
    minimumArray.append(minimum)
    maximumArray.append(maximum)
    weatherConditionArray.append(weatherCondition)
    day = ""
    minimum = ""
    maximum = ""
    weatherCondition = ""
else
    errorMsg = "Input cannot be empty"
endif

// Process for clearing input data when pressing the clear button
day = ""
minimum = ""
maximum = ""
weatherCondition = ""

// Output
display "Days:" + dayArray
display "Min Temperatures:" + minimumArray
display "Max Temperatures:" + maximumArray
display "Weather Conditions:" + weatherConditionArray

// Navigate to the next screen when pressing the next button
nextScreen(dayArray, minimumArray, maximumArray, weatherConditionArray)

Stop

// Function to navigate to the next screen
function nextScreen(dayArray, minimumArray, maximumArray, weatherConditionArray)
    // Process to take the data across to the next screen for more details
    display "Days: " + dayArray
    display "Min Temperatures: " + minimumArray
    display "Max Temperatures: " + maximumArray
    display "Weather Conditions: " + weatherConditionArray

    // Calculate the average temperature for the week
    num averageTemp = (sum(minimumArray) + sum(maximumArray)) / (2 * length(dayArray))
    display "Average Temperature for the week: " + averageTemp

    // Navigate back to the previous screen or main screen
    display "Press back to return to the previous screen"
    display "Press main screen to return to the main screen"
endfunction
