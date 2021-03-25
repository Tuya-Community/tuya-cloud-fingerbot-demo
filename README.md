## Tuya Develop Cloud --- Fingerbot MQ Sample

<p align="center">
    <a href="https://github.com/tuya/tuya-cloud-fingerbot-demo/commits/" title="Last Commit"><img src="https://img.shields.io/github/last-commit/tuya/tuya-cloud-fingerbot-demo?style=flat"></a>
    <a href="https://github.com/tuya/tuya-cloud-fingerbot-demo/blob/master/LICENSE" title="License"><img src="https://img.shields.io/badge/license-MIT-green?style=flat"></a>
    <a href="https://github.com/tuya/tuya-cloud-fingerbot-demo/issues" title="Open Issues"><img src="https://img.shields.io/github/issues/tuya/tuya-cloud-fingerbot-demo?style=flat"></a>
</p>

[中文版](README_zh.md)|[English](README.md)

![](img/fingerbot-demo.gif)

One of the most intriguing smart devices making waves at home and abroad recently is the Fingerbot from Adaprox. Using the app to turn lights on and off, voice activated and remotely open your office computer, you can say that any remote control of switches and buttons will be available via Fingerbot.

What is the power behind such a great fingerbot?

It is the Tuya cloud development platform, which is an open cloud platform for the Internet of Things created by Tuya. It provides various cloud services including OpenAPI for application developers, equipment manufacturers and solution providers of various industries, covering universal capabilities of core scenes such as device control, whole-house management and scene automation.

Message Service is used to actively push events data to external partners through **Pulsar**, which meets their demands for real-time and persistent messages.

### Security

- Authentication Tuya Smart Pulsar Message Service adopts the highly customized authentication algorithm and dynamic tokens to safeguard your operation. Developers can skip the implementation details and accomplish the authentication based on the provided SDK.
- Data Security Transmission security: Tuya Smart Pulsar Message Service transmits data based on the SSL. Business security: Business data is encrypted with AES-128 and attached with signature.



### Request method

- username: Fill in the **Access ID** of the Authorization Key generated in the Cloud Development.
- password: Fill in the **Access Secret** of the Authorization Key generated in the Cloud Development.
- url: Choose the endpoints according to your location.
  - China: `pulsar+ssl://mqe.tuyacn.com:7285/`
  - America: `pulsar+ssl://mqe.tuyaus.com:7285/`
  - Europe: `pulsar+ssl://mqe.tuyaeu.com:7285/`
  - India: `pulsar+ssl://mqe.tuyain.com:7285/`



### Procedure

1. Log into [Cloud Development in the IoT Platform console](https://iot.tuya.com/cloud/).
2. Create a Cloud Development project.
3. Activate message service in **Message Service**.

## Features

The following functional event messages are supported

### Device data reporting event

```
{
  "devId": "002dj00118fe34d9****",
  "productKey": "The product key defined in the Cloud Development",
  "dataId": "1459168450ddfdfoiopiopi****",
  "status": [
    {
      "Data point 1 (corresponding data point code in product definition)": "The value of data point 1",
      "t": 1540615024283  // The timing when the status of data point changed
    },
    {
      "Data point 2 (corresponding data point code in product definition)": "The value of data point 2",
      "t": 1540615024283 // The timing when the status of data point changed
    }
  ]
}
```



### Other Events

| bizCode       | Description                         |
| :------------ | :---------------------------------- |
| online        | Online                              |
| offline       | Offline                             |
| nameUpdate    | Modify the device name              |
| dpNameUpdate  | Modify data point name              |
| bindUser      | Bind the device with users accounts |
| Delete        | Remove device                       |
| upgradeStatus | Upgrade status                      |



## Quick Start

### Set Application.properties

```yml
mq.accessId= ******
mq.accessKey= ******
# event or event-test
mq.env=event
# CN_SERVER_URL:"pulsar+ssl://mqe.tuyacn.com:7285/"
# US_SERVER_URL:"pulsar+ssl://mqe.tuyaus.com:7285/"
# EU_SERVER_URL:"pulsar+ssl://mqe.tuyaeu.com:7285/"
# IND_SERVER_URL:"pulsar+ssl://mqe.tuyain.com:7285/"
mq.serverUrl=pulsar+ssl://mqe.tuyacn.com:7285/
mq.maxRedeliverCount=3
# true or false
mq.debug=true
```



### Start the project

Start this class **com.tuya.cloud.TuyaCloudFingerbotDemoApplication**, And look at the results



## Issue Feedback

You can provide feedback on your issue via **Github Issue** or [Technical Ticket](https://service.console.tuya.com/).

## License

Tuya Android Home SDK Sample is available under the MIT license. Please see the [LICENSE](https://github.com/tuya/tuya-cloud-fingerbot-demo/blob/master/LICENSE) file for more info.

