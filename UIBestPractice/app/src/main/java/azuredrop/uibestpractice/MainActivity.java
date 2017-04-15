package azuredrop.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> mMsgList = new ArrayList<>();

    private EditText mInputText;
    private Button mSendButton;
    private RecyclerView mMsgRecyclerView;
    private MsgAdapter mMsgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init messages
        initMsgs();

        // InputText
        mInputText = (EditText) findViewById(R.id.input_text);
        // SendButton
        mSendButton = (Button) findViewById(R.id.send);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mInputText.getText().toString();
                if (!"".equals(content)) {
                    // add to msglist
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    mMsgList.add(msg);

                    // notify view to update
                    mMsgAdapter.notifyItemInserted(mMsgList.size() - 1);
                    mMsgRecyclerView.scrollToPosition(mMsgList.size() - 1);

                    // clear input
                    mInputText.setText("");
                }
            }
        });
        // RecyclerView
        mMsgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mMsgRecyclerView.setLayoutManager(layoutManager);
        mMsgAdapter = new MsgAdapter(mMsgList);
        mMsgRecyclerView.setAdapter(mMsgAdapter);
    }

    private void initMsgs() {
        Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
        mMsgList.add(msg1);
        Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SENT);
        mMsgList.add(msg2);
        Msg msg3 = new Msg("This is Tom. Nice talking to you.", Msg.TYPE_RECEIVED);
        mMsgList.add(msg3);
    }
}
