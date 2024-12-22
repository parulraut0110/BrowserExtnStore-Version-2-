# Browser Extension Store (Version-2)

BrowserExtensionStore is a Spring Boot-based application designed for managing and storing browser extensions. This repository provides an API to upload, store, and manage extensions along with their metadata, including version history, upload date, and the extension's link to the Chrome Web Store.

### can also log in with google: -

![image](https://github.com/user-attachments/assets/c23ab0cb-b72f-4a4f-a3dd-4c20564d3715)

![image](https://github.com/user-attachments/assets/ed933d78-ac0f-4e9c-9416-035477baac22)

![image](https://github.com/user-attachments/assets/a16539de-b02d-49fb-91f2-aca11fb246c6)

### Search bar

![image](https://github.com/user-attachments/assets/844aa948-9461-42e8-945e-329938f53b16)

![image](https://github.com/user-attachments/assets/0e46236d-b4c6-4397-924e-6ce84d137644)

![image](https://github.com/user-attachments/assets/4f16ebd9-69f3-4a23-a127-4cabc5d58201)





## Features
- **Upload Extensions**: Upload and store browser extensions as binary data (BLOB).
- **Manage Metadata**: Save metadata such as extension name, developer ID, version number, upload date, last modified date, and Chrome Web Store link.
- **Version Control**: Track the version of each extension to maintain history.
- **REST API**: Offers an API endpoint for developers to interact with the system and upload extensions.

## Technologies Used
- **Java**: Core programming language used for backend logic.
- **Spring Boot**: Framework for creating stand-alone, production-grade Spring-based applications.
- **JPA (Java Persistence API)**: ORM tool used for mapping Java objects to database tables.
- **MySQL**: Relational database management system used to store extension data.
- **Maven**: Project management and build tool.

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.8.x or higher
- MySQL 8.x or higher

### Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/BrowserExtensionStore.git
    ```
2. Configure the MySQL database connection in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/browser_extension_db
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    ```
3. Run the application using Maven:
    ```bash
    mvn spring-boot:run
    ```

### API Endpoint
- **Upload Extension**:  
  Endpoint: `GET /mainController`  
  Description: Uploads an extension file and saves metadata like name, version, and browser link.


## Privacy Policy

At BrowserExtensionStore, we are committed to safeguarding the privacy of our users and developers. Below is our privacy policy:

1. **Data Collection**:  
   We collect only the essential data required to manage and store browser extensions. This includes the extension's name, version, developer ID, upload date, last modified date, and the extension's binary file.
   
2. **Use of Data**:  
   The collected data is used solely to store and manage browser extensions. We do not sell or share this data with third-party services.

3. **Data Retention**:  
   Data will be retained as long as the extension is stored in our system. If an extension is deleted, its associated data is permanently removed from our servers.

4. **Security**:  
   We take appropriate security measures to protect against unauthorized access, alteration, disclosure, or data destruction. However, no method of transmission over the Internet is completely secure, and we cannot guarantee its absolute security.

5. **User Rights**:  
   Users and developers have the right to request the deletion of their data or the removal of any uploaded extensions. For any privacy-related concerns, contact us at `parulraut0110@gmail.com`.

## License
This project is licensed.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with detailed information about your changes.

## Contact
For any questions or inquiries, feel free to contact `parulraut0110@gmail.com`.

## Older Version of this repository 
Check out [this repository](https://github.com/parulraut0110/BrowserExtensionStore) for more information.


```bash
{
  "_id": {
    "$oid": "66f81b301df06d56be87597d"
  },
  "serialNo": 1,
  "thumbnail": {
    "$binary": {
      "base64": "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",
      "subType": "00"
    }
  },
  "raters": 150,
  "ratings": [
    10,
    20,
    30,
    40,
    50
  ],
  "mimeType": "image/png",
  "reviews": [
    "Absolutely love this extension! It works flawlessly across all websites and even adjusts images perfectly. My eyes thank you!",
    "The dark mode is great, but some websites still show bright elements. It could use some fine-tuning for those. Overall, a helpful tool",
    "I installed it, but it makes certain text unreadable in some cases. Needs better contrast handling.",
    "A very basic implementation of dark mode. It gets the job done, but lacks customization options like auto-schedule.",
    "This is a game-changer for nighttime browsing. Seamless and works well across different browsers. A must-have!"
  ],
  "monthlyDownloads": [
    30,
    40,
    100,
    50
  ],
  "weeklyDownloads": [
    6,
    4,
    5,
    5,
    4,
    3,
    3
  ],
  "_class": "com.parul.BrowserExtnStore.Entity.Thumbnail"
}
```

```bash
CREATE FULLTEXT INDEX fulltext_idx ON extensions (extensionName, description);

```

```bash

{
  "_id": {
    "$oid": "67128a8dffc09b2820dbc845"
  },
  "serialNo": 1,
  "thumbnail": {
    "$binary": {
      "base64": "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",
      "subType": "00"
    }
  },
  "raters": 150,
  "ratings": [
    10,
    20,
    30,
    40,
    50
  ],
  "mimeType": "image/png",
  "monthlyDownloads": {
    "June": 40,
    "July": 70,
    "August": 30,
    "September": 60
  },
  "weeklyDownloads": {
    "Sat": 3,
    "Sun": 7,
    "Mon": 4,
    "Tue": 6,
    "Wed": 2,
    "Thur": 8,
    "Fri": 4
  },
  "totalDownloads": 200,
  "reviews": [
    "Absolutely love this extension! It works flawlessly across all websites and even adjusts images perfectly. My eyes thank you!",
    "The dark mode is great, but some websites still show bright elements. It could use some fine-tuning for those. Overall, a helpful tool",
    "I installed it, but it makes certain text unreadable in some cases. Needs better contrast handling.",
    "A very basic implementation of dark mode. It gets the job done, but lacks customization options like auto-schedule.",
    "This is a game-changer for nighttime browsing. Seamless and works well across different browsers. A must-have!"
  ],
  "lastDownloadedOn": {
    "$date": "2024-10-18T00:00:00.000Z"
  },
  "_class": "com.parul.BrowserExtnStore.Entity.Thumbnail"
}

```





  

