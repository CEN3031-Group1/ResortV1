# Resort Project
You are the owners of an up-and-coming resort. Business is booming, and you need a system that will automate your booking process. It will have a user-friendly interface for prospective guests, where they can enter dates, type of room, etc. for their stay as well as payment information. Your system shall produce summry report views for a manager and handle special cases such as cancellation or being sold out.

Upon further discussion with Dr. Koufakou, the project is shifted more onto a system management instead of booking . Guest reservations will come from an outside service (such as Kayak, Booking.com, etc.)

The programming language used is **Java**.
The project is subdivided in multiple versions. Each version will display its changes, major updates will condense all the changes in a single block of text in order to be easier to read. There is also a section that displays possible future features that can be added to the program, under the section **TODO**.

Final Documentation related to this project can be accessed [here](https://drive.google.com/drive/folders/1LB9RRYxb2T3-Lj7WudqFcAIZ3NMW687I).

## Project Description
Our goal is to implement a software for hotel’s guests and staff.
If a guest wants to have extra towels or shampoos, they  can go to the housekeeping page and request it. They will be able to request room service, as well as placing maintenance requests if they encounter issues in their room. There would be concierge services, where guest can find the best activities to enjoy in the city, such as restaurants, local venues, etc.
Hotel management will be able to track guest activities in real time, and as soon as they are completed, mark them as such.
There will be multiple classes of users, which can be seen in the **EmployeeTypes** section of the README.

## Installation
- System Requirements 
  - Any type of Operating System with Java installed.
  - Any program that can extract .zip files
  - 4Gb RAM
  - 1Gb Hard Disk
  
- Download this repository as a .zip file 
- Extract the .zip in a folder
- In the extracted folder, double click FGCU_Inn.jar file

Alternatively, using the command prompt utilize: ```java -jar FGCU_Inn.jar``` while being in the same directory as the file.

#### This will start the program. 


## ResortV1
Screens from Group1 and ResortProject repositories combined and modified to be more cohesive. 

### Major Update V1
- Linked every screen to each other, now each screen is loaded onto one Anchorpane! 
- Improved performance. 
- Fixed minor and major bugs. 
- Fixed paths in files (now all relative!). 
- Fixed naming issues.
- Separated screens from manager view.
- Added reports functionality.

## Login Test

userName | userPIN | isEmployee | empType
-------- | ------- | ---------- | --------
dickh | 1234 | 0 | 0
wyattb | 1684 | 1 | 1
bobb | 1111 | 1 | 2
lucam | 1215 | 1 | 3
tylerm | 1234 | 1 | 4
food | 1811 | 1 | 5

Employee Types (stored in EMPTYPES enum, checked by index):

index  |empType
-------|-------
0      |INVALID
1      |MANAGER
2      |HOUSEKEEPING
3      |MAINTENANCE
4      |VALET
5      |FOOD SERVICES

## TODO:
- [ ] Mark report as Done.
- [ ] Randomize background picture for screens
- [x] Database Integration
- [x] Exception throwing/catching to handle user authentication
- [ ] Add fields for guest user data(credit card number, email address, etc.) either to Users table or set up a join
- [ ] Integrate model code with view/controller code
- [ ] Checking existing database records to prevent duplicate record insertion

## Built With

* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - IDE of choice
* [SceneBuilder](https://gluonhq.com/products/scene-builder) - Great software to create GUI screens with ease
* [Apache PDFBox](https://pdfbox.apache.org/) - Create PDF for manager reports

## Plugins Used
* [FindBugs](http://findbugs.sourceforge.net/)
* [CheckStyle](http://checkstyle.sourceforge.net/config_naming.html#PackageName) - Google Checks used

## Authors

* **Luca Missaglia** - *Backend Developer, GitHub Manager* - [Lollators](https://github.com/Lollators)
* **Nathalie Crespo** - *Frontend Developer* - [Natt913](https://github.com/Natt913)
* **Alsu Saifetdinova** - *Frontend Developer, Project Manager* - [Alsu102](https://github.com/Alsu102)
* **Wyatt Byroade** - *Backend Developer, Database Manager* - [wabyroade](https://github.com/wabyroade)
* **Tyler Martin** - *Documentation Manager* - [tamartin9013](https://github.com/tamartin9013)

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE.md](LICENSE.md) file for details
