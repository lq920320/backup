

## 1. Cargo 下载依赖问题解决方案
您看到的是 Rust 的包管理器 Cargo 正在尝试下载项目依赖项，但遇到了网络超时问题。这是构建 Tauri 应用时必需的 Rust 依赖，总共需要下载 43 个 crates（Rust 包），大约 8.4MB 的数据。
### 为什么速度慢
在中国大陆地区，直接从官方源 crates.io 下载 Rust 包通常会很慢，甚至超时。这是因为:
- crates.io 服务器在国外 
- 可能存在网络限制 
- 没有使用国内镜像源
### 解决方法
#### 方法 1: 使用国内镜像源 (推荐)
在您的用户目录下创建或修改 .cargo/config.toml 文件：

```bash
# 创建配置目录
mkdir -p ~/.cargo

# 创建或编辑配置文件
nano ~/.cargo/config.toml
```

添加以下内容以使用中国科学技术大学的镜像:

```
[source.crates-io]
replace-with = 'ustc'

[source.ustc]
registry = "git://mirrors.ustc.edu.cn/crates.io-index"

# 如果 git 协议不工作，尝试使用 https
# registry = "https://mirrors.ustc.edu.cn/crates.io-index"

[net]
git-fetch-with-cli = true
```


#### 方法 2: 增加超时时间
如果不想使用镜像，可以尝试增加 Cargo 的超时设置：

```bash
# 在终端中设置环境变量
export CARGO_NET_TIMEOUT=120 # 设置为120秒（默认为30秒）

# 然后再运行构建命令
npm run tauri build
```

#### 方法 3: 使用代理（如果有）
如果您有代理服务器或 VPN，可以配置 Cargo 使用它：

```bash
# 设置 http 代理
export HTTP_PROXY=http://127.0.0.1:7890
export HTTPS_PROXY=http://127.0.0.1:7890
```

### 应用这些更改后
应用上述任何一种方法后，您需要重新运行构建命令：

```bash
npm run tauri build
```

或者先取消当前的构建，然后重新开始：

```bash
# 按 Ctrl+C 取消当前构建
# 然后重新运行
npm run tauri build
```

使用国内镜像源通常能将下载速度提升几十倍，使构建过程顺利完成。这只影响 Rust 依赖的下载，不会影响您应用程序的功能或分发。



## 2. 查看和升级 Rust 编译器版本

### 查看当前 rustc 版本
您可以通过运行以下命令来查看当前安装的 Rust 编译器版本：

```bash
rustc --version
```

这将显示类似于以下内容的输出：

```bash
rustc 1.76.0 (07dca489a 2024-02-04)
```

如果您使用 rustup 工具管理 Rust，您还可以查看所有已安装的 Rust 工具链：

```bash
rustup show
```

### 如何升级 Rust
#### 使用 rustup（推荐）
如果您是通过 rustup 安装的 Rust（这是最常见的安装方式），可以使用以下命令升级：

```bash
# 更新到最新稳定版
rustup update stable

# 或者简单地更新所有已安装的工具链和组件
rustup update
```

##### 验证升级是否成功
升级后，再次检查版本以确认：

```bash
rustc --version
```

##### 安装特定版本
如果您需要安装特定版本的 Rust：

```shell
# 安装特定的 Rust 版本
rustup install 1.77.0

# 设置为默认版本
rustup default 1.77.0
```

##### 安装 nightly 版本
如果您需要最新的开发特性：

```bash
# 安装 nightly 版本
rustup install nightly

# 设置为默认版本（可选）
rustup default nightly
```

#### 如果尚未安装 rustup
如果您还没有安装 rustup，或者不确定是否通过 rustup 安装的 Rust，可以运行：

```bash
# 检查 rustup 是否已安装
rustup --version

# 如果未安装，可以使用以下命令安装（在类 Unix 系统上）
curl --proto '=https' --tlsv1.2 -sSf https://sh.rustup.rs | sh
```

对于中国大陆用户，可以使用 USTC 镜像源加速安装：

```bash
# 设置环境变量
export RUSTUP_DIST_SERVER=https://mirrors.ustc.edu.cn/rust-static
export RUSTUP_UPDATE_ROOT=https://mirrors.ustc.edu.cn/rust-static/rustup

# 然后安装
curl --proto '=https' --tlsv1.2 -sSf https://sh.rustup.rs | sh
```

执行安装脚本后，按照提示操作即可完成安装。