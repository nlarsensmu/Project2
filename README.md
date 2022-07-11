TA Help Problem

# 1. Driver
In the Driver class we have a function TAHelp. This method will server as the TA.
A semaphore is created to control access to the TA.

## 1.1 Input
The input to this program is the path to a file that has a list of student names waiting to get into the TA's office. Each name should be on its own line.

## 1.2 TA Help
The TA Help, is a static function that will be called by all of the Students' run methods.
It will sleep for a sudo-random amount, from a set that is predefined. This method will print the name of the student it is helping, and print the time it took once the student is finished.

# 2 Student
The student class extends Thread. In the run method, we will just wait on the semaphore, run Driver.TAHelp, and then release the semaphore once we are done. 