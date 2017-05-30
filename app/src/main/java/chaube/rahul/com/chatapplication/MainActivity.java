package chaube.rahul.com.chatapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

import chaube.rahul.com.chatapplication.model.Message;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ImageButton button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.editText);
        button= (ImageButton) findViewById(R.id.submit);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User");
        final DatabaseReference conversation=database.getReference("conversation");
        DatabaseReference user=myRef.child("user_id");

       final DatabaseReference child=user.child("Message");
        child.push().setValue("rahul1993");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getKey=conversation.push().child("message").getKey();

                conversation.child(getKey).push().setValue(new Message(editText.getText().toString(),"Rahul","rahul@gmail.com","rahul@gmail.com",new Date().getTime(),"text",0l,"",0,false));
                editText.setText(" ");
            }
        });
        child.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()
                     ) {
                    Log.e("db",dataSnapshot1.getValue().toString());
//                    textView.setText(dataSnapshot1.getValue().toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Failed To Connect", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
