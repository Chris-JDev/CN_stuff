# CN\_stuff: Java Network Programming Examples

A collection of simple Java client-server programs demonstrating basic network communication patterns (TCP, UDP), multi-threading, and example services (Echo, Palindrome check, Arithmetic operations).

## Prerequisites

* **Java Development Kit (JDK)** 8 or newer installed and on your PATH.
* Basic familiarity with running commands in a terminal/command prompt.

## Repository Contents

```
ArithmeticClient.java   # Client for arithmetic operations service
ArithmeticServer.java   # Server handling arithmetic requests
PalindromeClient.java   # Client for palindrome-check service
PalindromeServer.java   # Server checking palindrome strings
TCPC.java               # TCP client example
TCPS.java               # TCP server example
UDPC.java               # UDP client example
UDPS.java               # UDP server example
multithread.java        # Multi-threaded server example
*.class files           # Compiled bytecode (can be ignored or deleted before recompiling)
```

## Setup & Compilation

1. **Clone the repo**

   ```bash
   git clone https://github.com/Chris-JDev/CN_stuff.git
   cd CN_stuff
   ```

2. **(Optional) Clean up old class files**

   ```bash
   rm *.class
   ```

3. **Compile all Java sources**

   ```bash
   javac *.java
   ```

## Running the Programs

Each example comprises a server and a client. Open **two** terminal windows (or tabs) for each pair.

### 1. UDP Echo Service

* **Start the UDP server** (listens on port 7878 by default):

  ```bash
  java UDPS
  ```
* **Run the UDP client** (sends a message and prints response):

  ```bash
  java UDPC
  ```

### 2. TCP Echo Service

* **Start the TCP server** (listens on default port; see source for actual port):

  ```bash
  java TCPS
  ```
* **Run the TCP client** (connects and echoes messages):

  ```bash
  java TCPC
  ```

### 3. Palindrome-check Service

* **Start the Palindrome server**:

  ```bash
  java PalindromeServer
  ```
* **Run the Palindrome client** (enter text to check):

  ```bash
  java PalindromeClient
  ```

### 4. Arithmetic Operations Service

* **Start the Arithmetic server**:

  ```bash
  java ArithmeticServer
  ```
* **Run the Arithmetic client** (enter expressions like `3+4`):

  ```bash
  java ArithmeticClient
  ```

### 5. Multi-threaded Server Example

* **Compile and run** (opens a server that handles each client in a new thread):

  ```bash
  javac multithread.java
  java multithread
  ```

  Connect using telnet or a matching client implementation.

## Notes

* If you modify any `.java` file, re-run `javac *.java` before executing.
* Ensure your firewall allows the chosen ports (often 7878 for UDP, others as defined in code).
* You can edit the port numbers and hostnames in the source files if needed.

---
