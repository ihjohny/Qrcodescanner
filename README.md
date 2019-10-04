# Qrcodescanner

<p align="center">
  <img src="screenshots/logo.png" >
</p>

Qrcodescanner is a client side android app for a QR code based attendance system (QR Code Attendance). QR Code Attendance System's backend was developed using Django. Which provide api for user login validation and sending QR code info to server. This repo contain only android client app. By using this app user can login to see his current percentage and scaning QR Code using mobile phone's camera to take attendance.

### Sample

Login Page |Profile Page 
-------------|-----------------
![alt text](screenshots/login_page.png "Login Page")  | ![alt text](screenshots/profile_page.png "Profile Page")


After QRcode Scan |Confirmation Page 
-------------|-----------------
![alt text](screenshots/after_qrscan.png "After QRcode Scan")  | ![alt text](screenshots/after_confirmation.png "Confirmation Page")


### Used libraries/tools:

* [Constraint Layout](https://developer.android.com/training/constraint-layout)
* [Barcode Scanner](https://github.com/dm77/barcodescanner)
* [Retrofit](http://square.github.io/retrofit/)


### License

```
Copyright 2019 Imam Hossain

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.