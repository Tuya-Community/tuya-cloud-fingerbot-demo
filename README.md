## Tuya Development Cloud—Fingerbot MQ Sample

<p align="center">
    <a href="https://github.com/tuya/tuya-cloud-fingerbot-demo/commits/" title="Last Commit"><img src="https://img.shields.io/github/last-commit/tuya/tuya-cloud-fingerbot-demo?style=flat"></a>
    <a href="https://github.com/tuya/tuya-cloud-fingerbot-demo/blob/master/LICENSE" title="License"><img src="https://img.shields.io/badge/license-MIT-green?style=flat"></a>
    <a href="https://github.com/tuya/tuya-cloud-fingerbot-demo/issues" title="Open Issues"><img src="https://img.shields.io/github/issues/tuya/tuya-cloud-fingerbot-demo?style=flat"></a>
</p>

[English](README.md)|[中文版](README_zh.md)

![](img/fingerbot-demo.gif)

One of the most intriguing and popular smart devices in the world is the Fingerbot from Adaprox. This app supports multiple functions. For example, you can use it to turn lights on and off, activate and remotely power on your office computer with voice assistants. Fingerbot supports the remote control of any switches and buttons.

What is the power behind such a great Fingerbot?

The Fingerbot is powered by the [Tuya Cloud Development Platform](https://iot.tuya.com/cloud/), an open IoT cloud platform created by Tuya. The platform provides a variety of cloud services including OpenAPI for application developers, device manufacturers, and solution providers in various industries. The Fingerbot covers general capabilities of core scenes, such as device control, smart home management, and scene automation.

Message service is used to actively push events to external partners based on **Pulsar**. This enables real-time and persistent messaging.

### Security

- Authentication security. Tuya Smart Pulsar Message Service adopts a highly customized authentication algorithm and dynamic tokens to safeguard your services. You can skip the implementation details and accomplish the authentication based on the provided SDK.
- Data transmission security: Tuya Smart Pulsar Message Service transmits data based on the SSL. 
- Business security: Business data is encrypted with AES-128 and attached with a signature.

### Request method

- `username`: Enter the **Access ID** of the Authorization Key generated on the [Tuya Cloud Development Platform](https://iot.tuya.com/cloud/).
- `password`: Enter the **Access Secret** of the Authorization Key generated on the [Tuya Cloud Development Platform](https://iot.tuya.com/cloud/).
- `url`: Choose the endpoint that is closest to your location.
  - China: `pulsar+ssl://mqe.tuyacn.com:7285/`
  - America: `pulsar+ssl://mqe.tuyaus.com:7285/`
  - Europe: `pulsar+ssl://mqe.tuyaeu.com:7285/`
  - India: `pulsar+ssl://mqe.tuyain.com:7285/`



### Procedure

1. Log in to the [Tuya Cloud Development Platform](https://iot.tuya.com/cloud/).
2. Create a Cloud Development project.
3. Subscribe to the message service in **Message Service**.

## Features

The following functional event messages are supported.

### Device data reporting event

```
{
  "devId": "002dj00118fe34d9****",
  "productKey": "The product key defined in the Cloud Development service",
  "dataId": "1459168450ddfdfoiopiopi****",
  "status": [
    {
      "Data point 1 (The data point code in product definition)": "The value of data point 1",
      "t": 1540615024283  // The time when the status of data point changed
    },
    {
      "Data point 2 (The data point code in product definition)": "The value of data point 2",
      "t": 1540615024283 // The time when the status of data point changed
    }
  ]
}
```



### Other events

| bizCode       | Description                         |
| :------------ | :---------------------------------- |
| online        | Online                              |
| offline       | Offline                             |
| nameUpdate    | Modify the device name              |
| dpNameUpdate  | Modify the data point name          |
| bindUser      | Bind the device to user accounts   |
| Delete        | Remove the device                       |
| upgradeStatus | Update status                      |



## Quick start

### Set application properties

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

Start this class **com.tuya.cloud.TuyaCloudFingerbotDemoApplication**, and check the results.



## Issue feedback

Provide feedback on your issue in **Github Issue** or [submit a ticket](https://service.console.tuya.com/).

## License

Tuya Android IoT App SDK Sample is available under the MIT license. For more information, see [License](https://github.com/tuya/tuya-cloud-fingerbot-demo/blob/master/LICENSE).

