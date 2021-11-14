# 태그 달린 클래스보다는 클래스 계층구조를 활용하라
* 두 가지 이상의 의미를 표현할 수 있으며, 그중 현재 표현하는 의미를 태그 값으로 알려주는 클래스를 본 적이 있을 것이다.
* 이렇게 태그 달린 클래스들은 장황해 가독성이 나쁘고, 오류를 내기 쉬우며, 메모리도 많이 소모하게 된다.

## 그러면.?
* 객체 지향에서는 클래스 계층구조를 활용하는 서브 타이핑 방법이 있다.
  * 태그 달린 클래스는 이를 어설프게 흉내낸 케이스일 뿐이다!
  * 클래스를 여러개 만들어 구현별로 나타내자