package model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Member;
import model.dao.MemberDAO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;

	// 登入 確認帳號比對密碼
	public Member login(String MAccount, String Mpwd) {
		Member member = memberDAO.select(MAccount);
		if (member != null && Mpwd.equals(member.getMPwd())) {
			return member;
		}
		return null;
	}

	// 註冊
	public Member register(String MAccount, String MPwd, String email, String MName, Boolean blacklist, byte[] photo) {
		Member temp = memberDAO.select(MAccount);
		if (temp == null) {
			Member addNew = new Member();
			addNew.setMAccount(MAccount);
			addNew.setMPwd(MPwd);
			addNew.setEmail(email);
			addNew.setMName(MName);
			addNew.setBlacklist(blacklist);
			addNew.setPhoto(photo);
			memberDAO.insert(addNew);

			return addNew;
		}
		return null;
	}

	// 忘記密碼
	public Member changePassword(String MAccount, String MPwd, String newPwd) {
		Member bean = this.login(MAccount, MPwd);
		if (bean != null) {
			if (newPwd != null && newPwd.trim().length() != 0) {
				return memberDAO.update(MAccount, newPwd, bean.getEmail(), bean.getMName(), bean.getBlacklist(),
						bean.getPhoto());
			}
		}
		return null;
	}

	// 更新資料
	public Member updateInfo(String MAccount, String MPwd, String newPwd, String newEmail, String newName,
			byte[] newPhoto) {

		Member update = memberDAO.select(MAccount);
		if (update == null) {
			return null;
		}
		// 確認哪些資料有被更新
		if (newPwd != null && newPwd.trim().length() != 0) {
			if (MPwd == null || MPwd.trim().length() == 0) {
               return null;
			} else {
			   Member temp = this.changePassword(MAccount, MPwd, newPwd);
			   if(temp!=null) {
				   update.setMPwd(newPwd);
			   }
			}		
		}

		if (newEmail != null && newEmail.trim().length() != 0) {
			update.setEmail(newEmail);
		}

		if (newName != null && newName.trim().length() != 0) {
			update.setMName(newName);
		}

		if (newPhoto != null && newPhoto.length != 0) {
			update.setPhoto(newPhoto);
		}
		// 更新資料
		return memberDAO.update(MAccount, update.getMPwd(), update.getEmail(), update.getMName(), update.getBlacklist(),
				update.getPhoto());
	}

	// 檢查帳號存在與否
	public boolean isExist(String MAccount) {
		boolean result = false;
		Member temp = memberDAO.select(MAccount);
		if (temp != null) {
			result = true;
			return result;
		}
		return result;
	}

}
