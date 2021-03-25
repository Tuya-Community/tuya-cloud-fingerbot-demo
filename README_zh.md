## Tuya Develop Cloud --- Fingerbot MQ Sample

<p align="center">
    <a href="https://github.com/tuya/tuya-cloud-fingerbot-demo/commits/" title="Last Commit"><img src="https://img.shields.io/github/last-commit/tuya/tuya-cloud-fingerbot-demo?style=flat"></a>
    <a href="https://github.com/tuya/tuya-cloud-fingerbot-demo/blob/master/LICENSE" title="License"><img src="https://img.shields.io/badge/license-MIT-green?style=flat"></a>
    <a href="https://github.com/tuya/tuya-cloud-fingerbot-demo/issues" title="Open Issues"><img src="https://img.shields.io/github/issues/tuya/tuya-cloud-fingerbot-demo?style=flat"></a>
</p>

[中文版](README_zh.md) | [English](README.md)

![](img/fingerbot-demo.gif)

最近有一款令人着迷的智能设备在国内外掀起了风波，这就是出自[Adaprox](https://www.adaprox.io/)家的fingerbot。通过应用程序开关灯，用声音激活并远程打开你的办公电脑，可以说任何开关和按钮的远程控制功能，通过fingerbot都可以实现。

如此强大的fingerbot, 它背后的力量是什么呢?

它就是涂鸦云开发平台，云开发平台是涂鸦打造的物联网云端开放平台，为各行业应用开发者、设备制造商、方案商提供了包含 OpenAPI 在内的各类云端服务，覆盖了设备控制、全屋管理、场景自动化等核心场景的通用能力。

开放消息平台主要通过 **Pulsar** 主动推送各种事件数据给外部合作伙伴，以满足合作伙伴对消息实时性和消息持久化的要求。

### 安全

- 认证安全：
  涂鸦智能 Pulsar 消息系统针对身份认证进行了深度定制以满足高安全性要求，涂鸦智能采用动态令牌机制增强安全，开发者可忽略实现细节，基于涂鸦智能提供的 SDK 完成认证。
- 数据安全：
  传输安全：涂鸦智能 Pulsar 消息推送系统基于 SSL 传输数据。
  业务安全：业务数据均采用 AES-128 加密，请求均附上签名。



### 请求方式

- username：填写云开发平台中 API 授权密钥的 **Access ID**。
- password：填写云开发平台中 API 授权密钥的 **Access Secret**。
- url：根据调用的区域进行选择。
  - 中国区：`pulsar+ssl://mqe.tuyacn.com:7285/`
  - 美国区：`pulsar+ssl://mqe.tuyaus.com:7285/`
  - 欧洲区：`pulsar+ssl://mqe.tuyaeu.com:7285/`
  - 印度区：`pulsar+ssl://mqe.tuyain.com:7285/`



### 开通方式

1. 登录 **[IoT 工作台](https://iot.tuya.com/) > 云开发**。
2. 创建项目。
3. 在项目中的**消息订阅**模块，开通消息订阅功能。



## 特色

下面这些事件消息是支持的

### 设备数据上报事件

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



### 其他事件

| bizCode       | 描述               |
| :------------ | :----------------- |
| online        | 设备上线           |
| offline       | 设备离线           |
| nameUpdate    | 修改设备名称       |
| dpNameUpdate  | 修改设备功能点名称 |
| bindUser      | 设备绑定用户       |
| delete        | 删除设备           |
| upgradeStatus | 设备升级状态       |



## 快速入门

### 设置Application.properties

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



### 启动工程

启动**com.tuya.cloud.TuyaCloudFingerbotDemoApplication**这个类，并观察结果



问题反馈
---

您可以通过**Github Issue** 或通过[**工单**](https://service.console.tuya.com)来进行反馈您所碰到的问题



LICENSE
---

Tuya Android Home SDK Sample是在MIT许可下提供的。更多信息请参考[LICENSE](https://github.com/tuya/tuya-cloud-fingerbot-demo/blob/master/LICENSE)文件