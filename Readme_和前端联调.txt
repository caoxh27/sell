1. http://192.168.0.32/#/           cookie里面没有openid的值，默认发生跳转到“请在微信客户端打开链接”的页面。
2. http://192.168.0.32/#/order      这个页面没有进行cookie的判断；可以在这个页面设定cookie：
                                    网页的命令窗口： document.cookie='openid=abc123'

192.168.0.32  --->  改名为 sell.com
1.  nginx.conf
2.  C:\Windows\System32\drivers\etc\hosts
http://sell.com/#/
http://sell.com/#/order 设定 document.cookie='openid=abc123'