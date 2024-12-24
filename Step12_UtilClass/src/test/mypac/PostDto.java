package test.mypac;

public class PostDto {
	//글번호
	private int id;
	//작성자
	private String writer;
	//제목
	private String title;
	
	public PostDto() {}

	public PostDto(int id, String writer, String title) {
		this.id = id;
		this.writer = writer;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
