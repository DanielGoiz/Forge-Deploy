package br.unit.forgek.dto;

public class VideoDTO {
    private Long id;
    private String video;

    public VideoDTO(Long id, String video) {
        this.id = id;
        this.video = video;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
