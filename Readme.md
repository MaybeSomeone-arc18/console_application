### Overview
A console application that queues up "scans" via typed commands and runs them one at a time in the background, while still accepting new commands at any moment — even mid-scan.
A “scan” is a dummy task which runs for the duration given by the user.
--
Example Output – 
Current Queue --> Scan:1, Scan A, 5, Yes
Command sent --> start
Output -->
Starting Scan A
(5 seconds pause in output)
Completed Scan A
Provided: Main.java

Implemented a ScanController (with a handleCommand(String command) method).


Requirements
Each scan has a state: IDLE, RUNNING, COMPLETE, or CANCELLED.
add queues a new scan.
view prints all the scans in queue.
start begins running scans one at a time, in order, automatically continuing to the next scan as each one finishes — unless the scan that just finished was added with pause, in which case scanning stops until start is called again.
Each scan should simulate running for its given duration (in seconds) before it's considered finished — it shouldn't complete instantly.
stop cancels whichever scan is currently running. The queue keeps going afterward.
remove takes a scan out of the queue, but only if it hasn't started yet.
exit exits the application.
The application must always stay responsive to commands — including while a scan is actively running.

