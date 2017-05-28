package chaube.rahul.com.chatapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.editText);
        button= (Button) findViewById(R.id.submit);
        textView= (TextView) findViewById(R.id.message);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User");
        DatabaseReference user=myRef.child("user_id");

       final DatabaseReference child=user.child("Message");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                child.push().setValue(editText.getText().toString());
                editText.setText("");
            }
        });
        child.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()
                     ) {
                    Log.e("db",dataSnapshot1.getValue().toString());
                    textView.setText(dataSnapshot1.getValue().toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Failed To Connect", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
