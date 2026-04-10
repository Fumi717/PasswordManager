# 🔐 Password Manager

A comprehensive command-line password management application built in Java. Store, view, search, edit, and manage your passwords with persistent file-based storage.

## ✨ Features

- **Add New Entries** – Store passwords with labels and usernames
- **View All Entries** – Display all saved passwords with numbered entries
- **Search by Label** – Quickly find entries using partial or full label matching
- **Edit Entries** – Modify passwords, labels, or usernames with confirmation prompts
- **Delete Entries** – Remove unwanted entries with safety confirmation
- **Persistent Storage** – Automatically saves to `passwords.txt` on every change
- **Input Validation** – Handles invalid inputs gracefully without crashing
- **Case-Insensitive Search** – Search for labels regardless of case

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any terminal/command prompt

### Installation

1. Save both Java files in the same directory:
   - `Main.java`
   - `PasswordManager.java`
   - `PasswordEntry.java`

2. Compile all Java files:
   ```bash
   javac *.java
