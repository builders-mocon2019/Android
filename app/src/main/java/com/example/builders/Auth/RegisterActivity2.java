package com.example.builders.Auth;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.example.builders.R;

public class RegisterActivity2 extends Activity {

    //회원가입 기능을 수행하는 Activity

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_register);

//        Fragment regiFrag1 = new RegiFragment1();
//        this.setDefaultFragment(regiFrag1);
//
//        Button button1 = findViewById(R.id.regi_btn1);
//        button1.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment regiFrag2 = new RegiFragment2();
//                replaceFragment(regiFrag2);
//            }
//        });
//    }
//
//    public void switchFragment() {
//        Fragment fr;
//        fr = new RegiFragment2();
//
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        fragmentTransaction.replace(R.id.regiFragment, fr);
//        fragmentTransaction.commit();
//    }
//
//    private void setDefaultFragment(Fragment defaultFragment)
//    {
//        this.replaceFragment(defaultFragment);
//    }
//
//    // Replace current Fragment with the destination Fragment.
//    public void replaceFragment(Fragment destFragment)
//    {
//        // First get FragmentManager object.
//        FragmentManager fragmentManager = this.getSupportFragmentManager();
//
//        // Begin Fragment transaction.
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        // Replace the layout holder with the required Fragment object.
//        fragmentTransaction.replace(R.id.regiFragment, destFragment);
//
//        // Commit the Fragment replace action.
//        fragmentTransaction.commit();
    }
}


//EditText, ProgressBar, Button 선언
//    EditText id, password, passwordcheck, nickname, intro;
//    ProgressBar regiProgress;
//    Button regiBtn;
//
//    //Firebase Authentication, Database 가져오기
//    private FirebaseAuth firebaseAuth;
//    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//    private DatabaseReference databaseReference = firebaseDatabase.getReference();
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE); //StatusBar 없애기
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //전체화면
//        setContentView(R.layout.activity_register_old);
//
//        //EditText findViewById
//        id = findViewById(R.id.reg_id);
//        nickname = findViewById(R.id.reg_nickname);
//        intro = findViewById(R.id.reg_intro);
//        password = findViewById(R.id.reg_password);
//        passwordcheck = findViewById(R.id.reg_passwordcheck);
//
//        firebaseAuth = FirebaseAuth.getInstance();// FireBase 현재 Auth 정보 가져오기
//
//        regiBtn = findViewById(R.id.btn_register); //Button findViewById
//        regiBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) { //회원가입 버튼이 클릭되었을 때
//
//                if (!nickname.getText().toString().equals("") && !intro.getText().toString().equals("")
//                        && !id.getText().toString().equals("") && !password.getText().toString().equals("")
//                        && !passwordcheck.getText().toString().equals("")) { //모든 항목이 기입되었을 경우
//                    createAccount(id.getText().toString(), password.getText().toString(), passwordcheck.getText().toString(), nickname.getText().toString(), intro.getText().toString()); //기입한 정보로 회원가입 진행
//                }
//                else { //채워지지 않은 항목이 있을 경우
//                    Toast.makeText(getApplicationContext(), "빈칸을 채워주세요", Toast.LENGTH_SHORT).show(); //빈칸 기입 요청 토스트
//                }
//            }
//        });
//    }
//
//    private boolean isValidPasswd(String target) { //패스워드 유효성 검사 함수
//        Pattern p = Pattern.compile("(^.*(?=.{8,50})(?=.*[0-9])(?=.*[a-z]).*$)"); //패스워드 검사 정규식. 8~50자, 알파벳+숫자
//        Matcher m = p.matcher(target); //정규식 대입 검사
//        return m.find() && !target.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*"); //정규식 검사값이 옳고 한글이 포함되지 않았다면 true 반환
//    }
//
//    private boolean isValidEmail(String target) { //Email 유효성 검사 함수
//
//        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches(); //Email 유효성 검사 결과 반환
//    }
//
//    private void createAccount(final String email, final String password, final String passwordcheck, final String nickname, final String intro) { //회원가입 함수
//
//        //ProgressBar findViewById
//        regiProgress = findViewById(R.id.progress_regi);
//
//        regiProgress.setVisibility(View.VISIBLE); //ProgressBar 표시
//
//        if (!isValidEmail(email)) { //이메일 유효성 검사에 실패할 경우
//            Toast.makeText(getApplicationContext(), "이메일이 유효하지 않습니다", Toast.LENGTH_SHORT).show(); //이메일 유효성검사 실패 토스트
//            regiProgress.setVisibility(View.INVISIBLE); //ProgressBar 숨기기
//            return;
//        }
//
//        if (!isValidPasswd(password)) { //패스워드 유효성 검사에 실패할 경우
//            Toast.makeText(getApplicationContext(), "패스워드가 유효하지 않습니다", Toast.LENGTH_SHORT).show(); //패스워드 유효성 검사 실패 토스트
//            regiProgress.setVisibility(View.INVISIBLE); //ProgressBar 숨기기
//            return;
//        }
//
//        if (!password.equals(passwordcheck)) { //패스워드와 패스워드 재입력이 일치하지 않는 경우
//            Toast.makeText(getApplicationContext(), "패스워드가 일치하지 않습니다", Toast.LENGTH_SHORT).show(); //재입력 불일치 토스트
//            regiProgress.setVisibility(View.INVISIBLE); //ProgressBar 숨기기
//            return;
//        }
//
//        firebaseAuth.createUserWithEmailAndPassword(email, password) //Firebase에 회원가입 요청
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() { //작업 완료 리스너
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) { //회원가입에 성공했다면
//                            FirebaseUser user = firebaseAuth.getCurrentUser(); //현재 유저 정보 가져오기
//                            String[] profileColorList = getApplicationContext().getResources().getStringArray(R.array.colors); //colors 목록에서 프로필 색상 리스트 가져오기
//                            int profileColor = Color.parseColor(profileColorList[new Random().nextInt(profileColorList.length)]); //가져온 리스트에서 랜덤 색상 선택
//                            UserModel model = new UserModel(nickname, email, user.getUid(), "#" + intro, profileColor); //UserModel 양식에 회원가입 정보 추가
//                            databaseReference.child("user").push().setValue(model); //작성한 model 양식을 Firebase DB에 등록
//                            Toast.makeText(getApplicationContext(), "환영합니다, " + id.getText().toString() + "!", Toast.LENGTH_SHORT).show(); //회원가입 성공 토스트
//                            finish();
//                        }
//                        else { //회원가입에 실패했다면
//                            Toast.makeText(getApplicationContext(), "회원가입 실패", Toast.LENGTH_SHORT).show(); //회원가입 실패 토스트
//                            regiProgress.setVisibility(View.INVISIBLE); //ProgressBar 숨기기
//                        }
//                    }
//                });
//
//
//    }
