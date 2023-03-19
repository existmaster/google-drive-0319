package google.drive.domain;

import google.drive.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class FIleIndexed extends AbstractEvent {

    private Long id;
    private String fileId;
    private List<String> keyworkds;
}