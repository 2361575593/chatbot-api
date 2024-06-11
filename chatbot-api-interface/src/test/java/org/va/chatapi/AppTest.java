package org.va.chatapi;

import static org.junit.Assert.assertTrue;

import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void zsxqMsgPullTest() throws URISyntaxException, IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet();
        get.setURI(new URI("https://api.zsxq.com/v2/groups/48888584885558/topics?scope=unanswered_questions&count=20"));
        get.addHeader("Content-Type","application/json;charset=utf8");
        get.addHeader("cookie","zsxq_access_token=BB69852B-8E3E-8A41-AD21-162D14FFBCFC_F27D3D551761956F; zsxqsessionid=3058bb3615c98c9f78f42788a0fe890f; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22818284141158842%22%2C%22first_id%22%3A%22190051997a8421-0944b0251547d9-4c657b58-1327104-190051997a9af3%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTkwMDUxOTk3YTg0MjEtMDk0NGIwMjUxNTQ3ZDktNGM2NTdiNTgtMTMyNzEwNC0xOTAwNTE5OTdhOWFmMyIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjgxODI4NDE0MTE1ODg0MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22818284141158842%22%7D%7D");

        CloseableHttpResponse response = client.execute(get);

        System.out.println(EntityUtils.toString(response.getEntity(),""));


    }

    @Test
    public void answerQuestion() throws URISyntaxException, IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost();
        post.setURI(new URI("https://api.zsxq.com/v2/topics/8855485154548442/answer"));
        post.addHeader("Content-Type","application/json;charset=utf8");
        post.addHeader("cookie","zsxq_access_token=BB69852B-8E3E-8A41-AD21-162D14FFBCFC_F27D3D551761956F; zsxqsessionid=3058bb3615c98c9f78f42788a0fe890f; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22818284141158842%22%2C%22first_id%22%3A%22190051997a8421-0944b0251547d9-4c657b58-1327104-190051997a9af3%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTkwMDUxOTk3YTg0MjEtMDk0NGIwMjUxNTQ3ZDktNGM2NTdiNTgtMTMyNzEwNC0xOTAwNTE5OTdhOWFmMyIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjgxODI4NDE0MTE1ODg0MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22818284141158842%22%7D%7D");

        String answer = "{\"req_data\":{\"text\":\"测试成功\\n\",\"image_ids\":[]}}";
        StringEntity entity = new StringEntity(answer, ContentType.create("text/json"));
        post.setEntity(entity);
        CloseableHttpResponse response = client.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            System.out.println(EntityUtils.toString(response.getEntity()));

        }else {
            System.out.println("请求失败");
        }


    }
}
