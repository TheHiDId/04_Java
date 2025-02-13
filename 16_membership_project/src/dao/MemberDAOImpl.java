package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Member;

public class MemberDAOImpl implements MemberDAO {
	private final String FileName = "MemberList.bin";
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	private List<Member> memberList = null;
	
	public MemberDAOImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		File memberListBin = new File(FileName);
		
		if(memberListBin.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(memberListBin));
				
				memberList = (List<Member>)ois.readObject();
				
			} finally {
					if(ois != null) ois.close();
			}
		} else {
			memberList = new ArrayList<Member>();
		}
	}

	@Override
	public List<Member> getMemberList() {
		return memberList;
	}

	@Override
	public boolean addMember(Member member) throws IOException {
		
		memberList.add(member);
		
		saveFile();
		
		return false;
	}

	@Override
	public void saveFile() throws IOException {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FileName));
			
			oos.writeObject(memberList);
			
		} finally {
				if(oos != null) oos.close();
		}
	}
}
