package com.example.dellll.test;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listLevel;
    public static final String Mainpostion = "key";
    Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db.DELL_QueryData("CREATE TABLE IF NOT EXISTS tbLEVEL (tb1_id INTEGER PRIMARY KEY AUTOINCREMENT, tb1_name NVARCHAR(200) NOT NULL, tb1_image NVARCHAR(200) NOT NULL, tb1_number NVARCHAR(200) NOT NULL, tb1_status NVARCHAR(200) NOT NULL)");
        db.DELL_QueryData("CREATE TABLE IF NOT EXISTS tbWORD (tb2_id INTEGER PRIMARY KEY AUTOINCREMENT, tb2_word NVARCHAR(200) NOT NULL, tb2_huongdan NVARCHAR(200) NOT NULL, tb2_consonant NVARCHAR(200) NOT NULL, tb2_audio NVARCHAR(200) NOT NULL, tb2_level NVARCHAR(200) NOT NULL, tb2_status NVARCHAR(200) NOT NULL)");

        Cursor kq = db.DELl_GetData("SELECT * FROM tbLEVEL");
        if (kq.getCount() == 0) {
            db.DELL_QueryData("INSERT INTO tbLEVEL VALUES(NULL,'Level 0','R.drawable.l1', '0', '0')");
            db.DELL_QueryData("INSERT INTO tbLEVEL VALUES(NULL,'Level 1','R.drawable.l1', '0', '0')");
            db.DELL_QueryData("INSERT INTO tbLEVEL VALUES(NULL,'Level 2','R.drawable.l1', '1', '0')");
            db.DELL_QueryData("INSERT INTO tbLEVEL VALUES(NULL,'Level 3','R.drawable.l1', '2', '0')");

            //lv1
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'joy','Đọc tương tự như joi, chú ý âm dʒ ở đầu', '/dʒɔɪ/','joy', '1','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'gin','Đọc tương tự như jin, chú ý âm dʒ ở đầu', '/dʒɪn/','gin', '1','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'edging','Đọc tương tự như ejiNG, chú ý âm dʒ sau âm /e/', '/ˈedʒɪŋ/','edging', '1','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'age','Đọc tương tự như āj, chú ý âm dʒ sau âm /ā/', '/eɪdʒ/','age', '1','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'jam','Đọc tương tự như jam, chú ý âm dʒ ở đầu', '/dʒæm/','jam', '1','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'jeep','Đọc tương tự như jēp, chú ý âm dʒ ở đầu', '/dʒiːp/','jeep', '1','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'stage','Đọc tương tự như stāj, chú ý âm dʒ ở cuối', '/steɪdʒ/','stage', '1','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'joke','Đọc tương tự như jōk, chú ý âm dʒ ở đầu, ngoài ra còn âm /k/ ở cuối', '/dʒəʊk/','joke', '1','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'large','Đọc tương tự như lärj, chú ý âm dʒ ở cuối, âm /l/ ở đầu lưỡi hơi cong lên vòm họng', '/lɑːdʒ/','large', '1','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'jug','Đọc tương tự như jəg, chú ý âm dʒ ở đầu', '/dʒʌg/','jug', '1','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'june','Đọc tương tự như jun, chú ý âm dʒ ở đầu', '/dʒuːn/','june', '1','0')");

            //lv2
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'judge','Đọc tương tự như jəj, chú ý âm dʒ ở đầu và cuối', '/dʒʌdʒ/','judge', '2','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'soldier','Đọc tương tự như ˈsōljər, chú ý âm dʒ ở giữa, nhấn từ ở đầu', '/ˈsəʊldʒə(r)/','soldier', '2','0')");
            /*db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'verdure','Đọc tương tự như ˈvərjər, chú ý âm dʒ ở giữa', '/ˈvɜːdʒə(r)/','verdure', '1','0')");*/
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'schedule','Đọc tương tự như ˈskejo͞ol, chú ý âm dʒ ở giữa, cuối âm /l/ lưỡi hơi cong lên vòm họng nhấn đầu từ', '/ˈskedʒuːl/','schedule', '2','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'ginger','Đọc tương tự như ˈjinjər, chú ý âm dʒ ở đầu và giữa', '/ˈdʒɪndʒə(r)/','ginger', '2','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'cage','Đọc tương tự như kāj, chú ý âm dʒ ở cuối, âm /k/ đọc nhẹ', '/keɪdʒ/','cage', '2','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'stage','Đọc tương tự như stāj, chú ý âm dʒ ở cuối', '/steɪdʒ/','stage', '2','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'village','Chú ý âm dʒ ở cuối', '/ˈvɪlɪdʒ/','village', '2','0')");
            /*db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'cottage','Đọc tương tự như joi, chú ý âm dʒ ở đầu', '/ˈkɒtɪdʒ/','cottage', '1','0')");*/
            /*db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'gem','Đọc tương tự như joi, chú ý âm dʒ ở đầu', '/dʒem/','gem', '1','0')");*/


            //lv3
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'gigantic','Hướng dẫn đọc đang biên soạn!', '/ˌdʒaɪˈgæntɪk/','gigantic', '3','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'gymnastic','Hướng dẫn đọc đang biên soạn!', '/dʒɪmˈnæstɪk/','gymnastic' ,'3','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'geology','Hướng dẫn đọc đang biên soạn!', '/dʒiˈɒlədʒi/','geology', '3','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'lunge','Hướng dẫn đọc đang biên soạn!', '/lʌndʒ/','lunge', '3','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'jew','Hướng dẫn đọc đang biên soạn!', '/dʒuː/','jew', '3','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'hedge','Hướng dẫn đọc đang biên soạn!', '/hedʒ/','hedge', '2','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'danger', 'Hướng dẫn đọc đang biên soạn!','/ˈdeɪndʒə(r)/','danger', '3','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'schedule','Hướng dẫn đọc đang biên soạn!', '/ˈskedʒuːl/','schedule', '3','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'college','Hướng dẫn đọc đang biên soạn!', '/ˈkɑːlɪdʒ/','college', '3','0')");
            db.DELL_QueryData("INSERT INTO tbWORD VALUES(NULL,'gem','Hướng dẫn đọc đang biên soạn!', '/dʒem/','gem', '3','0')");


        }

        listLevel = (ListView) findViewById(R.id.lv);
        ArrayList<Level> arrayList = new ArrayList<>();

        Cursor level = db.DELl_GetData("SELECT * FROM tbLEVEL");
        while (level.moveToNext()) {
            Level lv = new Level(level.getString(1), level.getString(3), level.getString(4));
            arrayList.add(lv);
        }

        Adapter customAdapter = new Adapter(this, R.layout.itemlevel, arrayList);
        listLevel.setAdapter(customAdapter);

        listLevel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0)
                {
                    Intent intent2 = new Intent(MainActivity.this, HuongdanActivity.class);

                    startActivity(intent2);
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, ContentLevelActivity.class);
                    intent.putExtra(Mainpostion, position);
                    if (position == 1) {
                        startActivity(intent);
                    } else {
                        int temp = position - 1;
                        Cursor kq = db.DELl_GetData("SELECT * FROM tbWORD WHERE tbWORD.tb2_level ='" + temp + "'");
                        int flag = 0;
                        while (kq.moveToNext()) {
                            if (kq.getString(6).equals("0")) {
                                flag = 1; //chua hoan thanh het
                                break;
                            }
                        }
                        if (flag == 0) {
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Level chưa được mở khóa, hãy hoàn thành các level chưa được hoàn thành!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}
