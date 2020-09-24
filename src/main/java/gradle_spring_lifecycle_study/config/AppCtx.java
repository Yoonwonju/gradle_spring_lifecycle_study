package gradle_spring_lifecycle_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gradle_spring_lifecycle_study.di.ChangePasswordService;
import gradle_spring_lifecycle_study.di.MemberDao;
import gradle_spring_lifecycle_study.di.MemberInfoPrinter;
import gradle_spring_lifecycle_study.di.MemberListPrinter;
import gradle_spring_lifecycle_study.di.MemberPrinter;
import gradle_spring_lifecycle_study.di.MemberRegisterService;
import gradle_spring_lifecycle_study.di.VersionPrinter;

@Configuration			//해당 클래스를 스프링 설정 클래스로 지정한다.
public class AppCtx {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}
	
	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(memberPrinter());
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}

	@Bean
	  public MemberInfoPrinter infoPrinter() {
	      MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
	      infoPrinter.setMemberDao(memberDao());
	      infoPrinter.setPrinter(memberPrinter());
	      return infoPrinter;
	}
	
}
