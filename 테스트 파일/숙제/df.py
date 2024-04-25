# <aside>
# <img src="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1574221064/noticon/xjal9z4a8h46soi6ktgo.png" alt="https://noticon-static.tammolo.com/dgggcrkxq/image/upload/v1574221064/noticon/xjal9z4a8h46soi6ktgo.png" width="40px" /> **파이썬으로 다음 연산을 수행한다.**

# 죄수의 딜레마는 게임 이론의 유명한 사례이다

# - [https://ko.wikipedia.org/wiki/죄수의_딜레마](https://ko.wikipedia.org/wiki/%EC%A3%84%EC%88%98%EC%9D%98_%EB%94%9C%EB%A0%88%EB%A7%88)

# 두 명의 범죄자 A, B가 체포되어 서로 다른 취조실에서 격리되어 심문을 받고 있다. 이들에게 자백 여부에 따라 다음의 선택이 가능하다.

#  - 둘 중 하나가 배신하여 죄를 자백하면 자백한 사람은 즉시 풀어주고 나머지 한 명이 10년을 복역해야 한다.
#  - 둘 모두 서로를 배신하여 죄를 자백하면 둘 다 5년을 복역한다.
#  - 둘 모두 죄를 자백하지 않으면 둘 다 1년을 복역한다.

#  죄수를 나타내는 변수 `XA`, `XB`는 자백하면 `True`, 그렇지 않으면 `False`를 가지는 값이다. 이때 변수 `XA`, `XB` 값에 따라 각각이 복역해야 하는 연 수를 변수 `YA`, `YB`라고 할 때 `YA`, `YB`를 계산하는 프로그램을 만든다.

#  </aside>

XA = input("A용의자 : ")
XB = input("B용의자 : ")

YA = "석방"
YB = 10

# 방법1
if (XA == "자백" or XB == "자백"):
  if (XA == "자백" and XB == "자백"):
    print("5년")
  elif (XA == "자백"):
    print(f"A는 {YA} B는 {YB}년")
  else:
    print(f"A는 {YB}년 B는 {YA}")
else:
  print("6개월")

# 방법2
if (XA == "자백" and XB == "자백"):
  print("5년")
elif (XA == "자백" and XB == "침묵"):
  print(f"A는 {YA} B는 {YB}년")
elif (XA == "침묵" and XB == "자백"):
  print(f"A는 {YB}년 B는 {YA}")
else:
  print("6개월")








