## 平台即服务（PaaS）是什么？

### 平台即服务（PaaS）是什么？

在平台即服务（PaaS）模型中，开发人员基本上租用构建应用程序所需的一切，这些都依赖于提供开发工具、基础设施和操作系统的云提供商。这是云计算三种服务模型的其中一种。PaaS 极大简化了 web 应用程序的开发；从开发人员的角度来看，所有的后端管理都是在幕后进行的。虽然 PaaS 与 [无服务器计算](https://www.cloudflare.com/learning/serverless/what-is-serverless/) 有一些相似之处，但是二者之间还是有挺大的不同的。

### 云计算的三种服务模型是什么？

云计算的三种模型即 PaaS，SaaS（软件即服务），以及 IaaS（基础设施即服务）。IaaS 是指由云供应商管理的云计算基础设施（服务器、存储等），而 SaaS 是整个应用程序指托管在云中并由 SaaS 供应商维护。如果将一位 SaaS 客户比作租户，那么 PaaS 客户就像一个租用所有重型设备和强力工具来快速建房子的人，而且这些工具设备是由其拥有者进行持续维护的。

### PaaS 与内部托管的开发环境相比如何？

PaaS 可以通过任何物联网连接访问，从而可以在一个 web 浏览器中构建整个应用程序。由于开发环境不是本地托管的，开发人员可以在世界的任何地方对应用程序进行开发。即使是分布在不同地理位置的团队也能够协作。这也意味着开发人员对开发环境的控制更少，然而这同时会带来更少的开销。

### PaaS 中包括什么？

PaaS 供应商提供的主要产品包括：

- 开发工具
- 中间件
- 操作系统
- 数据库管理
- 基础设施

虽然不同的供应商可能也会包括其它服务，但这些是核心的 PaaS 服务。

##### 开发工具

PaaS 供应商提供了各种各样软件开发必需的工具，包括源码编辑器、调试工具、编译器，以及其它必要的工具。这些工具可能会作为一个框架一起提供。特定工具将取决于供应商，但 PaaS 产品应该包括开发人员构建其应用程序所需的一切。

##### 中间件

作为服务的平台通常会包括中间件，所以开发人员不必自己来构建它。中间件是位于面向用户的应用程序和机器操作系统之间的软件；比如，中间件允许软件从键盘和鼠标输入来访问。对于运行应用程序，中间件是必需的，但最终用户并不与其进行交互。 

##### 操作系统

PaaS 供应商会提供并维护一个操作系统，用以开发人员的开发工作和应用程序运行。

##### 数据库

PaaS 提供者会管理和维护数据库。它们通常也会为开发人员提供数据库管理系统。

##### 基础设施

PaaS is the next layer up from IaaS in the cloud computing  service model, and everything included in IaaS is also included in PaaS.  A PaaS provider either manages servers, storage, and physical data  centers, or purchases them from an IaaS provider.



##### 更快地投入市场

PaaS 用于构建应用程序的速度，可能比开发人员必须考虑构建、配置和供应自己的平台以及后端基础设施来构建应用的速度要更快。有了 PaaS，开发人员他们只需要编写代码和测试应用程序，而供应商会解决剩下的问题。

##### 由始自终一个环境

PaaS 允许开发人员在同等环境中构建、测试、调试、部署、托管和更新他们的应用程序。这使开发人员能够确保 web 应用在发布前能够正常运行，以及会简化应用程序开发周期。

##### 价格

PaaS is more cost-effective than leveraging IaaS in many  cases. Overhead is reduced because PaaS customers don't need to manage  and provision virtual machines. In addition, some providers have a  pay-as-you-go pricing structure, in which the vendor only charges for  the computing resources used by the application, usually saving  customers money. However, each vendor has a slightly different pricing  structure, and some platform providers charge a flat fee per month.

在许多情况下，使用 PaaS 比 IaaS 更具成本效益。成本的降低源于 PaaS 的用户无需去管理和提供虚拟机。此外，

##### 许可证的便利性

PaaS providers handle all licensing for operating systems, development tools, and everything else included in their platform.

## What are the potential drawbacks of using PaaS?

#### Vendor lock-in

It may become hard to switch PaaS providers, since the  application is built using the vendor's tools and specifically for their  platform. Each vendor may have different architecture requirements.  Different vendors may not support the same languages, libraries, APIs,  architecture, or operating system used to build and run the application.  To switch vendors, developers may need to either rebuild or heavily  alter their application.

#### Vendor dependency

The effort and resources involved in changing PaaS vendors  may make companies more dependent on their current vendor. A small  change in the vendor's internal processes or infrastructure could have a  huge impact on the performance of an application designed to run  efficiently on the old configuration. Additionally, if the vendor  changes their pricing model, an application may suddenly become more  expensive to operate.

#### Security and compliance challenges

In a PaaS architecture, the external vendor will store most  or all of an application's data, along with hosting its code. In some  cases the vendor may actually store the databases via a further third  party, an IaaS provider. Though most PaaS vendors are large companies  with strong security in place, this makes it difficult to fully assess  and test the security measures protecting the application and its data.  In addition, for companies that have to comply with strict data security  regulations, verifying the compliance of additional external vendors  will add more hurdles to going to market.

## How is Platform-as-a-Service different from serverless computing?

PaaS and serverless computing are similar in that for both,  all a developer has to worry about is writing and uploading code, and  the vendor handles all backend processes. However, scaling is vastly  different when using the two models. Applications built using serverless  computing, or FaaS, will scale automatically, while PaaS applications  will not unless programmed to do so. Startup times also vary greatly;  serverless applications can be up and running almost instantly, but PaaS  applications are more like traditional applications and have to be  running most of the time or all of the time in order to be immediately  available for users.

Another difference is that serverless vendors do not provide  development tools or frameworks, as PaaS vendors do. And finally,  pricing separates the two models. PaaS billing is not nearly as precise  as in serverless computing, in which charges are broken down to the  number of seconds or fractions of a second each instance of a function  runs.
