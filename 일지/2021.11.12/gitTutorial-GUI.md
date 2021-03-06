# Git Tutorial-GUI
* 이번에는 GUI인 소스트리로 구조를 살펴보자.

# 목차
## [소스트리 사용하기](#소스트리-사용하기)
<br>
<br>

## 깃의 구조
* 큰 범위의 프로젝트 폴더 안에 세 구역으로 나뉜다.
  * 작업 공간
  * 로컬 저장소 (.git)
  * 스테이지


### git add
* 작업 공간의 파일들을 `스테이지`로 올리는 명령어.
* 이때 파일들을 스냅샷을 찍어 변경사항이 없으면 변경사항이 없다면 스테이지에 올리지 않고 변경사항이 있는 파일들만 스테이지에 저장.

### git commit
* 스테이지에 있는 파일들을 하나로 묶어 로컬 저장소에 저장

### git push
* 로컬 저장소에 있는 커밋을 원격 저장소에 저장.


## branch
* 왜 커밋을 branch로 나누는가?
  * 여러 사용자들이 하나의 코드를 수정하면서 충돌이 날 가능성이 있어서.
* 그럼 나중에 합치는가?
  * 맞다! 충돌이 나더라도 나중에 합치는 기능(merge)를 제공한다!

## git branch <name>
* branch를 만들고 싶은 경우 `git branch branch명` 명령어를 통해 만들 수 있다.
* 보통 branch명을 만들 때 검색이 편하게 기능/이름 식으로 짓는다.
  * 예시 : `feat/comment` : 댓글 남기기
  * 예시 : `feat/login` : 로그인 

### git branch 팁
* 보통 `feat/기능이름`으로 한 사람이 개발하는 기능 브랜치를 만든다.
* 버그의 경우 `fix/버그이름`, `hotfix/버그이름`을 사용한다.
* 작업이 끝나면 `dev (or master)` 브랜치로 `pull request`를 보낸다.
* 큰 작업들이 모두 `dev (or master)` 브랜치에서 머지되면 `release (or latest)` 브랜치로 머지시키고 이를 실서버에 배포한다.
* `직접 커밋`은 `feat, fix, hotfix` 브랜치에만 한다.
* 나머지 브랜치들은 모두 `커밋이 아닌 머지(pull request)`만 실시한다

<br></br>
***
<br>

## git checkout <branch name>
* 해당 branch로 이동하고 싶을 때 `checkout` 명령어를 사용한다. 

## git merge
* 각 `브랜치`에서 작업이 모두 끝났을 때 슬슬 합칠 준비를 해야 한다.
* 우선 base 브랜치로 이동한 후... (분기가 시작되는 곳)
* 합치길 원하는 분기의 브랜치를 선택
* `git merge 합치길 원하는 분기의 브랜치명`
* 결과는 당연히 합치길 원하는 분기의 브랜치명이 나오게 된다.
  * base 브랜치에서 파생된 것이기 때문에 당연한 말이다.

## Conflict
* 합치다가 충돌이 난 경우!
* 보통 합치려고 할 때 같은 파일이 커밋되어 있는 경우 발생하게 된다.
```
readme.md
1. 업데이트 했습니다.
2. 했다니깐요!
```

```
readme.md
1. 업데이트 했을까요?
2. 몰라요~
```
* 이 경우 충돌!
* base 분기가 아닌 다른 분기의 브랜치가 합쳐지는 경우에 발생.


### 해결책
* 이 경우 사용자가 수동으로 고쳐주어야 한다.

<br></br>
***
<br>

## git fork
* 저장소를 통째로 복사하는 기능
* 복사해온 저장소에 자유롭게 `commit`, 및 `push`를 하고 기존 권한을 가지고 있는 사람들에게 `merge`를 요청


|종류|의의|장점|단점|
|---|:----:|:------:|:------:|
|브랜치|하나의 원본 저장소에서 분기를 나눠준다.|하나의 원본 저장소에서 코드 커밋 이력을 편하게 볼 수 있다.|다수의 사용자가 다수의 브랜치를 만들면 관리하기 힘들다.|
|포크|여러 원격 저장소를 만들어 분기를 나눈다.|원본 저장소에 영향을 미치지 않으므로 코드를 마음껏 수정이 가능하다.|원본저장소의 이력을 보여면 따로 주소를 추가해줘야 한다.|

## pull request
* 머지하기 싶은 두 브랜치를 선택하고 (`base, compare`)
* 어떻게 변경을 했는지 제목과 내용을 쓴 후 권한이 없는 사용자가 권한이 있는 사용자에게 요청.

### 팁
* 코드를 함께 작성하는 팀원이 있다면 직접 머지는 최대한 피하고 `pull request`!!
* 동료들이 내 `PR`을 보고 코드리뷰가 가능하다.
* 동료의 PR에 수정이 필요하면 댓글을 달아 change request를 보낼 수 있다.
* 오픈소스에 PR을 보낼때 `contribution guideline`을 반드시 참고하자