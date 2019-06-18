
## 什么是无服务计算？

无服务计算是一种在使用的基础上提供后端服务的方法。`Serverless` 的供应商允许用户编写和发布代码，而不用担心其底层基础设施。从 `serverless` 供应商处获取后端服务的公司根据其计算量收取费用，并且不必为固定数量的带宽或服务器数量预留和支付费用，因为该服务是自动伸缩的。得注意一点，虽说是无服务器，但物理服务器仍在使用，但开发人员不需要意识到它们的存在。 

在早期 Web 时代，任何想要构建一个 web 应用的人都需要拥有运行服务器所需的物理硬件，这是一项既麻烦又昂贵的工作。

然后有了云，固定数量的服务器和服务器存储空间可被远程租用。开发人员以及公司租用这些固定服务器存储空间单元时，通常会过度购买，以确保流量或活动的激增不会超过每月的限制然后破坏其应用程序。这就意味着付过款的大部分服务器存储空间通常是浪费的。云供应商已经推出了自动伸缩模型来解决这个问题，但即使会对活动一些不期望的峰值，比如说一次 [DDos 攻击](https://www.cloudflare.com/learning/ddos/what-is-a-ddos-attack/)，进行自动伸缩，最终也可能非常昂贵。

无服务器计算允许开发人员在灵活的“按需购买”的基础上来购买后端服务，这就意味着开发人员只需为他们使用的服务付费。就像是从一个每月固定限额的手机数据套餐，切换到一个只对实际使用的每一字节数据收费的套餐。 

术语“serverless”多少有些误导，因为依旧有服务器会提供这些后端服务，只是所有服务器存储空间和基础结构问题都由供应商来处理。这么理解的话，无服务器（Serverless）就是开发人员可以在不必担心服务器的情况下完成他们的工作。

### 什么是后端服务？前后端的不同之处是什么？

应用开发通常分为两个领域：前端和后端。前端就是应用中用户可以看到并进行交互的那部分，比如说视觉布局。后端就是用户看不到的那部分；包括应用程序文件所在的服务器和用户数据和业务逻辑所在的数据库。


For example, let’s imagine a website that sells concert tickets. When  a user types a request into the browser window, the browser sends a  request to the backend server, which responds with the website data. The  user will then see the frontend of the website, which will include  text, images, and form fields for the user to fill out. The user can  then interact with one of the form fields on the frontend to search for  their favorite musical act. When the user clicks on ‘submit’, this will  trigger another request to the backend. The backend code checks its  database to see if a performer with this name exists, and if so, when  they will be playing next, and how many tickets are available. The  backend will then pass that data back to the frontend, and the frontend  will display the results in a way that makes sense to the user.  Similarly, when the user creates an account and enters financial  information to buy the tickets, another back-and-forth communication  between the frontend and backend will occur.

## What kind of backend services can serverless computing provide?

Most serverless providers offer database and storage services to their customers, and many also have [Function-as-a-Service (FaaS)](https://www.cloudflare.com/learning/serverless/glossary/function-as-a-service-faas/) platforms, like [Cloudflare Workers](https://www.cloudflare.com/products/cloudflare-workers/). These platforms can execute pieces of code on the edge without storing any data.

## What are the advantages of serverless computing?

- **Lower costs** - Serverless computing is generally  very cost-effective, as traditional cloud providers of backend services  (server allocation) often result in the user paying for unused space or  idle CPU time.
- **Simplified scalability** - Developers using  serverless architecture don’t have to worry about policies to scale up  their code. The serverless vendor handles all of the scaling on demand.
- **Simplified backend code** - With FaaS, developers can create simple functions that independently perform a single purpose, like making an API call.
- **Quicker turnaround** - Serverless architecture can  significantly cut time to market. Instead of needing a complicated  deploy process to roll out bug fixes and new features, developers can  add and modify code on a piecemeal basis.
