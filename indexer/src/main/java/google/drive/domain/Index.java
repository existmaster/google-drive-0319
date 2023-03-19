package google.drive.domain;

import google.drive.IndexerApplication;
import google.drive.domain.FIleIndexed;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Index_table")
@Data
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileId;

    @ElementCollection
    private List<String> keyworkds;

    @PostPersist
    public void onPostPersist() {
        FIleIndexed fIleIndexed = new FIleIndexed(this);
        fIleIndexed.publishAfterCommit();
    }

    public static IndexRepository repository() {
        IndexRepository indexRepository = IndexerApplication.applicationContext.getBean(
            IndexRepository.class
        );
        return indexRepository;
    }

    public static void indexFile(FileUploaded fileUploaded) {
        /** Example 1:  new item 
        Index index = new Index();
        repository().save(index);

        FIleIndexed fIleIndexed = new FIleIndexed(index);
        fIleIndexed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(fileUploaded.get???()).ifPresent(index->{
            
            index // do something
            repository().save(index);

            FIleIndexed fIleIndexed = new FIleIndexed(index);
            fIleIndexed.publishAfterCommit();

         });
        */

    }
}
