package example.com.ap_and;

import android.app.Activity;
import android.os.Bundle;

import com.example.ap_and.annotation;

public class MainActivity extends Activity {
    @annotation
    public static class MyClass
    {
        public MyClass() {
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
