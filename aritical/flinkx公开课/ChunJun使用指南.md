# ChunJun使用指南

ChunJun 是易用、稳定、高效的批流一体的[数据集成框架](https://www.zhihu.com/search?q=数据集成框架&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"article"%2C"sourceId"%3A"555512982"})，主要应用于大数据开发平台的数据同步 / 数据集成模块，使大数据开发人员可简洁、快速的完成数据同步任务开发，供企业数据业务使用。

本文主要整理 ChunJun 的各类链接以及如何提交 pr、Issue 的方法，希望大家更好地参与开源，参与社区。

# ChunJun 百科

● 开源地址

GitHub：[https://github.com/DTStack/chunjun](https://link.zhihu.com/?target=https%3A//github.com/DTStack/chunjun)

Gitee：[https://gitee.com/dtstack_dev_0/chunjun](https://link.zhihu.com/?target=https%3A//gitee.com/dtstack_dev_0/chunjun)

● 官方网站

[https://dtstack.github.io/chunjun/](https://link.zhihu.com/?target=https%3A//dtstack.github.io/chunjun/)

● 快速入门文档

[https://dtstack.github.io/chunjun-web/docs/chunjunDocs/quickstart/](https://link.zhihu.com/?target=https%3A//dtstack.github.io/chunjun-web/docs/chunjunDocs/quickstart/)

● 视频课程

Flink StreamSQL 基础课程：

[https://space.bilibili.com/677474984/channel/seriesdetail?sid=738125](https://link.zhihu.com/?target=https%3A//space.bilibili.com/677474984/channel/seriesdetail%3Fsid%3D738125)

2021 年 ChunJun 课程：

[https://space.bilibili.com/677474984/channel/seriesdetail?sid=738126](https://link.zhihu.com/?target=https%3A//space.bilibili.com/677474984/channel/seriesdetail%3Fsid%3D738126)

2022 年 ChunJun 课程：

[https://space.bilibili.com/677474984/channel/seriesdetail?sid=2240634](https://link.zhihu.com/?target=https%3A//space.bilibili.com/677474984/channel/seriesdetail%3Fsid%3D2240634)

● 课件获取

关注公众号 “ChunJun”，回复 “课件”，即可获得您需要的对应课程的课件。

# 提交 pr&Issue 指南

## 如何提交一个优秀的 pr

在 GitHub 上提交 pr 是参与 ChunJun 项目开源的一个重要途径，小伙伴们在使用中的一些功能上 feature 或者 [bugfix](https://www.zhihu.com/search?q=bugfix&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"article"%2C"sourceId"%3A"555512982"}) 都可以向社区提交 pr 贡献代码，也可以根据已有的 Issue 提供自己的解决方案。

● 第一步：[fork](https://www.zhihu.com/search?q=fork&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"article"%2C"sourceId"%3A"555512982"}) ChunJun 到自己的 GitHub 仓库



![img](http://mk-pig.oss-cn-hangzhou.aliyuncs.com/img/v2-b73291c3a2af660ab47556dc6fe64400_b.jpg)

点击 fork 后就可以在自己仓库中看到以你名字命名的 ChunJun 项目了：





![img](http://mk-pig.oss-cn-hangzhou.aliyuncs.com/img/v2-b7078bb3fc0075cba0d4a9d5ca13ef6e_b.jpg)



● 第二步：clone ChunJun 到本地 IDE



![img](http://mk-pig.oss-cn-hangzhou.aliyuncs.com/img/v2-4307d9c9878d0cb00ed88bd92db7450d_b.jpg)



● 第三步：将 DTStack/ChunJun 设置为本地仓库的远程分支 upstream



![img](http://mk-pig.oss-cn-hangzhou.aliyuncs.com/img/v2-2bb540c947e47ce99ff18f3f3a3c805f_b.jpg)



● 第四步：提交代码

任何一个提交都要基于最新的分支 切换分支



![img](http://mk-pig.oss-cn-hangzhou.aliyuncs.com/img/v2-d7e6546bf0ded57661b2c7640a03725b_b.jpg)

本地修改代码后，提交 commit



[commit_message](https://www.zhihu.com/search?q=commit_message&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"article"%2C"sourceId"%3A"555512982"}) 格式： [commit_type][module] message

commit_type:

feat：表示是一个新功能（feature)

hotfix：hotfix，修补 bug

docs：改动、增加文档

opt：修改代码风格及 opt imports 这些，不改动原有执行的代码

test：增加测试

eg:[hotfix-12345][mysql] Fix mysql time type loses precision.



![img](http://mk-pig.oss-cn-hangzhou.aliyuncs.com/img/v2-31fe8a7494cfff52001c838136407447_b.jpg)

rebase 远程分支



这一步很重要，因为我们仓库中的 chunjun 代码很有可能已经落后于社区，所以我们 push commit 前需要 [rebase](https://www.zhihu.com/search?q=rebase&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"article"%2C"sourceId"%3A"555512982"})，保证我们的 commit 是基于社区最新的代码，很多小伙伴没有这一步导致提交的 pr 当中包含了其他人的 commit



![img](http://mk-pig.oss-cn-hangzhou.aliyuncs.com/img/v2-0b6daa18a3dedc42a0c38ed5daa17a96_b.jpg)

rebase 后有可能出现代码冲突，一般是由于多人编辑同一个文件引起的，只需要根据提示打开[冲突文件](https://www.zhihu.com/search?q=冲突文件&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"article"%2C"sourceId"%3A"555512982"})对冲突部分进行修改，将提示的冲突文件的冲突都解决后，执行





![img](http://mk-pig.oss-cn-hangzhou.aliyuncs.com/img/v2-1749c5f2bd2b655622bdc9de27bd01bd_b.jpg)

依此往复，直至屏幕出现类似 [rebase successful](https://www.zhihu.com/search?q=rebase+successful&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"article"%2C"sourceId"%3A"555512982"}) 字样即可



rebase 之后代码可能无法正常推送，需要 git push -f 强制推送，强制推送是一个有风险的操作，操作前请仔细检查以避免出现无关代码被强制覆盖的问题

push 到 github 仓库



![img](http://mk-pig.oss-cn-hangzhou.aliyuncs.com/img/v2-0105772bf92edbf936c2d15d7a3f3ca6_b.jpg)



● 第五步：提交 pr

以我修复 [kafka](https://www.zhihu.com/search?q=kafka&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"article"%2C"sourceId"%3A"555512982"}) 写入过程中出现空指针问题为例，经过步骤四我已经把代码提交至我的仓库 master 分支



![img](http://mk-pig.oss-cn-hangzhou.aliyuncs.com/img/v2-0197b06a3508e8b4f55e1a042f45ba7f_b.jpg)

进入 ChunJun 仓库页面，点击 Pull Request





![img](http://mk-pig.oss-cn-hangzhou.aliyuncs.com/img/v2-28538542c52138d7e47a0d79fb121a4e_b.jpg)

![img](http://mk-pig.oss-cn-hangzhou.aliyuncs.com/img/v2-28538542c52138d7e47a0d79fb121a4e_b.jpg)

选择 head 仓库和 base 仓库以及相应的分支





![img](http://mk-pig.oss-cn-hangzhou.aliyuncs.com/img/v2-47e91434363ed11484cd457de7731f65_b.jpg)

填写 [pr 信息](https://www.zhihu.com/search?q=pr信息&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"article"%2C"sourceId"%3A"555512982"})，pr 信息应该尽量概括清楚问题的前因后果，如果存在对应 Issue 要附加 Issue 地址，保证问题是可追溯的





![img](http://mk-pig.oss-cn-hangzhou.aliyuncs.com/img/v2-8af4070973cfa6581b635200698c331f_b.jpg)

![img](http://mk-pig.oss-cn-hangzhou.aliyuncs.com/img/v2-414bc1e7ac0fc1161e9c76a460c58a66_b.jpg)

pr 提交成功后需要一段时间代码 review，您可以耐心等待一下我们 review 后合入，或者直接联系我们，提交 pr 的同学更有机会加入我们共创小组。



## 如何正确进行 [pr review](https://www.zhihu.com/search?q=pr+review&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"article"%2C"sourceId"%3A"555512982"})

● pr review

・如果是简单的代码或者文档改动，review 结束可以直接合并

・如果是较大的内容改动，需要对应模块 owner review

・如果是功能分支，需要 pr 中提供设计思路，有必要的情况下，提供设计文档

・pr 回复时间不能超过一周

・不符合规范的 pr 在回复提示过后仍未改动，不予合并，一周之后关闭

● review pr 的要求

・在 pr 里备注修复的 issue

・pr commit 模版 [hotfix-#issueID][#fix-module] #fix-commit.

・修改内容尽量保持与 issue 内容一致，如果出现无关修改，在 pr 中备注出来

・review 代码时注意代码格式化

## 如何正确提出一个 Issue

issue 是一种非常好的可沉淀、可复现、可跟踪的交流方式，如果您发现了 ChunJun 有任何 bug 或奇怪的性能特征，请在 GitHub 或 Gitee 中提交新的 Issue。

目前我们团队主要在 GitHub 上解决 Issue 和 pr 相关内容，Gitee 上会相对慢一些，大家如果有 Issue 或者 pr 尽量在 GitHub 上提出，我们会及时处理。

● 在 GitHub 上提交的新 Issue 分为以下几种：

・反馈错误 (Bug Reports)

・提交新需求 (Feature Requests)

・常规问题 (General Questions)

・性能问题 (Performance Questions)

● 进行高效提问的方法

请您详细描述存在问题 + 问题截图，提交到 ChunJun 的 Issue，以便我们迅速定位问题并作出回应。

Issue 地址：

[https://github.com/login?return_to=https%3A%2F%2Fgithub.com%2FDTStack%2Fchunjun%2Fissues%2Fnew%2Fchoose](https://link.zhihu.com/?target=https%3A//github.com/login%3Freturn_to%3Dhttps%3A%2F%2Fgithub.com%2FDTStack%2Fchunjun%2Fissues%2Fnew%2Fchoose)

不了解如何高效进行提问的同学，请阅读下面两篇文章：

《提问的智慧》：

[https://github.com/ryanhanwu/How-To-Ask-Questions-The-Smart-Way/blob/main/README-zh_CN.md](https://link.zhihu.com/?target=https%3A//github.com/ryanhanwu/How-To-Ask-Questions-The-Smart-Way/blob/main/README-zh_CN.md)

《[社区提问指南](https://www.zhihu.com/search?q=社区提问指南&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"article"%2C"sourceId"%3A"555512982"})》：

[https://github.com/ryanhanwu/How-To-Ask-Questions-The-Smart-Way/blob/main/README-zh_CN.md](https://link.zhihu.com/?target=https%3A//github.com/ryanhanwu/How-To-Ask-Questions-The-Smart-Way/blob/main/README-zh_CN.md)

● 提交 Issue 需要注意的地方

提交的 Issue 最好带上详细的复现问题的步骤，这样可以减少其他同步复现问题的时间，更快更有效地解决问题。

如果能定位到源码的问题，建议提交一个 pr 来修复它，而不是等待其他同学。

# 社群交流技巧

除了 GitHub 和 Gitee 之外，我们还有一个拥有 3000 多人的[开源框架](https://www.zhihu.com/search?q=开源框架&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"article"%2C"sourceId"%3A"555512982"})技术交流群，在群内，大家可以尽情交流 ChunJun 相关技术和资讯，各位开发者们互帮互助，一串代码、一个建议，都是对 ChunJun 的莫大帮助。

开源框架交流钉钉群号码：30537511



对于社群，我们希望它能够成为一个所有对开源、对 ChunJun 有兴趣的朋友的交流场所，而不是一个单纯的答疑群。在群里，不论是 ChunJun 团队成员还是你们，所有人的角色都是 ChunJun 的爱好者和共建者，而不是 “客服”“机器人” 这样的角色。

当您对于 ChunJun 有疑问时，我们首先推荐您搜索相关文档，如果不能得到答案，强烈建议您通过提交 Issue 和我们进行沟通，最后才是在社群内提问。因为通过提交 Issue 的方式，问题可以得到沉淀，社群内消息刷新得很快，一个不小心，您的问题就石沉大海了。

我们团队成员平时还有自己的工作，没办法守在电脑前一个个回复社群中的问题，所以**勇敢地提出 Issue 吧，那一刻，你就已经变成了开源项目的参与者**！

ChunJun 团队也将根据大家的反馈，定期更新迭代官方文档，不断完善项目质量，和你们一起共建 ChunJun。

[袋鼠云](https://www.zhihu.com/search?q=袋鼠云&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"article"%2C"sourceId"%3A"555512982"})开源框架钉钉技术交流群（30537511），欢迎对大数据开源项目有兴趣的同学加入交流最新技术信息，开源项目库地址：[https://github.com/DTStack](https://link.zhihu.com/?target=https%3A//github.com/DTStack)