package google.drive.domain;

import google.drive.domain.*;
import google.drive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FIleIndexed extends AbstractEvent {

    private Long id;
    private String fileId;
    private List<String> keyworkds;

    public FIleIndexed(Index aggregate) {
        super(aggregate);
    }

    public FIleIndexed() {
        super();
    }
}
