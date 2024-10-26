# TCP Chat Application

A simple TCP-based chat application with server and client components.

## Project Structure
```
tcp-chat-app/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── chat/
│                   ├── server/
│                   │   ├── ChatServer.java
│                   │   └── ClientHandler.java
│                   └── client/
│                       └── ChatClient.java
├── bin/
├── lib/
├── docs/
└── scripts/
    ├── build.sh
    ├── run-server.sh
    └── run-client.sh
```

## Building the Application

To build the application, run:

```bash
./scripts/build.sh
```

## Running the Application

1. Start the server:
```bash
./scripts/run-server.sh
```

2. Start the client (in a different terminal):
```bash
./scripts/run-client.sh
```

## Usage

- Type messages in the client terminal and press Enter to send
- Type 'bye' to exit
