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
 
**Testing Priority**: Charters are stacked up according to the priority 
- App installation/ Update is what user encounters in case of this app. Also any installation failure would block user from using the app & potantially hamper the brand.
- Adding Income / Expense are core features of the app, rest all are features complementing the core.
 
## 1 Install and update application (Planned time: 2 hours)
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

## 2 Expense / Income (Planned time: 4 hours)
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
2. Scheduled income/expenses records
3. Synchronization with Dropbox and Google Drive

## 3 Testing on different devices (Planned time: 1.5 hours)
We need to check that the app is responsive and looks the same on devices with a different form factor.
- Nexus 6P (Viewport 412 x 732)
- Samsung Galaxy S7 (Viewport 360 x 640)
- Tablets ex: Samsung Galaxy Tab 10 (Viewport 800 x 1280)
This is a sample set of devices selected based on the viewport to ensure we test the app on both ends of the spectrum. Additional factor while choosing devices could be the user base using devices. 

## 4 Localization testing (Planned time: 3 hours)
Monefy support several languages: English, Bulgarian, Croatian, German, Italian, Malay, Polish, Portuguese, Russian, Simplified Chinese, Spanish, Turkish, Ukrainian.
So we need to check that everything is translated correctly in chosen languages when we choose a language in the app settings.

## 5 Device specific tests (Planned time: 1 hours)
We need to check how Monefy app behave:
- if there is an incoming call/message
- if a device goes to/from sleeping mode, or when a screen is locked
- if a device is charging, or battery is low

## 6 Network testing (Planned time: 1 hours)
We need to check how Monefy app behave:
 - when it connected to the Internet through Wi-Fi
 - when it connected to the Internet through 4G
 - when it connected to the Internet through 3G
 - when it out of network reach
 - App behaviour after app regains internet connectivity

## 7 Third party Integration testing (for PRO version) (Planned time: 2 hours)
According to Monefy feature list, in its PRO version Synchronization with Google Drive and Dropbox is available, which allows users to use the same account on several devices. 

|#|target| Step | Information to discover |
| ------ | ------ | ------ | ------ |
|1|Third party integration| Open Monefy on the device A| Monefy app is opened|
|2|Third party integration| Enable synchronization with Google Drive| Synchronization is enabled|
|3|Third party integration|Open Monefy on the device B and use the same account as at device A| Monefy app is opened under the same account|
|4|Third party integration|Add some expenses| Expenses are added, changes are displayed on the main screen |
|5|Third party integration|Check how expenses are displayed in the app on device A| Expenses are synchronized and displayed the same way as on device B|

## Findings:

## Risks to mitigate: