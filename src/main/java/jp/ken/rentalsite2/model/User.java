package jp.ken.rentalsite2.model;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class User implements Serializable {
	
	private String id;
	@NotEmpty(message="名前は必須入力です。")
	@Length(min=1,max=20,message="1文字以上20文字以下で入力してください。",groups=Group2.class)
	private String name;
	@NotEmpty(message="パスワードは必須入力です。")
	@Length(min=1,max=20,message="1文字以上20文字以下で入力してください。",groups=Group2.class)
	private String password;
	@NotEmpty(message="フリガナは必須入力です。")
	@Length(min=1,max=20,message="1文字以上20文字以下で入力してください。",groups=Group2.class)
	private String kana;
	@NotEmpty(message="年齢は必須入力です。")
	@Length(min=1,max=20,message="1文字以上3文字以下で入力してください。",groups=Group2.class)
	private String age;
	@NotEmpty(message="性別は必須入力です。")
	private String gender;
	@NotEmpty(message="住所は必須入力です。")
	@Length(min=1,max=20,message="1文字以上40文字以下で入力してください。",groups=Group2.class)
	private String address;
	@Pattern(regexp="^[0-9]{3}-[0-9]{4}-[0-9]{4}$|^[0-9]{2,4}-[0-9]{2,4}-[0-9]{4}$|",
			message="携帯電話または家庭電話の番号形式ではありません。",groups=Group1.class)
	@NotEmpty(message="電話番号は必須入力です。")
	@Length(min=1,max=20,message="1文字以上20文字以下で入力してください。",groups=Group2.class)
	private String phone;
	@Email(message="メールアドレスの形ではありません。")
	@NotEmpty(message="メールアドレスは必須入力です。")
	@Length(min=1,max=40,message="1文字以上20文字以下で入力してください。",groups=Group2.class)
	private String mail;
	@NotEmpty(message="生年月日は必須入力です。")
	@Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}",
	message="生年月日のフォーマットが正しくありません",groups=Group1.class)
	@Length(min=1,max=20,message="1文字以上15文字以下で入力してください。",groups=Group2.class)
	private String birthday;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getKana() {
		return kana;
	}
	public void setKana(String kana) {
		this.kana = kana;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
