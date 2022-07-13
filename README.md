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
The student class extends Thread. In the run method, the student will alternate between asking the TA for help and working on their own. Before asking the TA for help the student must ensure the TA is not helping another student by obtaining the semaphore for the TA. To simulate both getting helped and perform indivdual work the thread will sleep for a sudo-random amount of time from a predetermeined list of random times.

# Output
* Each line of output will start with the thread name
* If the TA is helping a student A it will say "Helping student A"
* If the TA is finished helping student A it will say "Helping studnet: A took X units"
* If the student is doing indivudal work it will say "A is working on their own for X units"
* If the student is done working on their own it will say "A finished their task that took X units"
* Once a studnet leaves the TA's office it will say "A left the TA's office"