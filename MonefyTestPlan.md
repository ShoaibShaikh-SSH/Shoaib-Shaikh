# **Test plan for Monefy mobile app (Android)**

**Object of testing**: Monefy mobile application (Not subscribed to pro version of the app).

**App Version**: 1.9.19

**OS**: Android 10 or higher

**Devices**: Huawei Honor 8x

**Testing Objective**: 
Monefy is a money management tool which allows users to track their expenses and income. Considering the app has a pro version, the business goal is to sell it to the customer. This goal can be achieved if the primary functions of the app are working flawlessly and a customer has a positive user experience. 
So, our focus areas will be:
 - The application can be installed and updated without losing user data
 - Working of primary features: Adding money to total balance, Adding expenses, Checking calculations of total expenses and income for over a specific period, checking categories of expenses & income breakup
 - User doesn't have access to pro features
 - Design of the app is responsive and looks the same on devices with a different form 
 
 
## 1 Install and update application
### 1.1 Install & Launch application
|#|target| Step | Information to discover |
| ------ | ------ | ------ | ------ |
|1| App installation| Install Monefy app from play Store | Successfull/Unsuccessful app installation |
|2|App Launch| Open the application after installation| Launching of Application. The default landing page |


### 1.2 Update application
|#|target| Step | Information to discover |
| ------ | ------ | ------ | ------ |
|1| App update |Update the application from play store| Application updated to new version |
|2| User data retention| Check user data in the updated app|User data displayed as it was before the update |

**Additional step for PRO version**

|#|target| Step | Information to discover |
| ------ | ------ | ------ | ------ |
|1|PRO features | Check PRO version features availability after app update| PRO version features availability after update |

## 2 Expense / Income
### 2.1 Adding new income
|#|target| Step | Information to discover |
| ------ | ------ | ------ | ------ |
|1|Add Income|Tap '+' button | Form for adding new income is opened |
|2|Add Income|Enter sum, add a note and choose a category| App shows the main screen. Balance field and income in the pie chart are updated. System message appeared with info about the operation & option to 'cancel' |
|3|Add Income|Tap on balance button | List of balance operations is displayed divided by category names|
|4|Add Income|Tap on operation category that we chose on step 3| List of completed operations in this category is displayed, operation from step 3 also in this list |

### 2.2 Adding new expenses
|#|target| Step | Information to discover |
| ------ | ------ | ------ | ------ |
|2|Add Expense|Tap '-' button | Form for adding new expense is opened |
|3|Add Expense|Enter sum, add a note and choose a category| App shows the main screen. Balance field and expenses in the pie chart are updated. System message with info about the operation & option to 'cancel' |
|4|Add Expense|Tap on balance button |  List of balance operations is displayed divided by category names|
|5|Add Expense|Tap on operation category that we chose on step 3| List of completed operations in this category is displayed, operation from step 3 also in this list |

### 2.3 Other features
Also, we can test other features:
1. Adding expenses by tapping on the expenses category icon on dashboard
2. Customize main screen info by choosing a time period (day/week/month/year/all/chosen date) or/and account
3. Transfer money between user accounts
4. Adding a new account (default currency)
5. App customization settings
6. Balance settings
7. Data backup

### 2.4 PRO version features
We should check that pro features aren't available until user upgrades to pro version
List of these features:
1. Adding new categories
2. Create accounts in different currencies
3. Scheduled income/expenses records
4. Synchronization with Dropbox and Google Drive
5. Passcode protection
6. Dark theme