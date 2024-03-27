package hello.core.singleton;

public class SingletonService {

    // static: 정적 변수로 작용해서 클래스 레벨에서 하나만 만들어져서 올라간다.
    private static final SingletonService instance = new SingletonService();

    // 생성된 인스턴스를 반환하는 메서드 - 이를 통해 서비스에 접근할 수 있다.
    public static SingletonService getInstance(){
        return instance;
    }

    // 새로운 인스턴스의 생성을 막기위해 private 생성자를 - 싱글톤 패턴
    private SingletonService() {

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출 ");
    }


}
