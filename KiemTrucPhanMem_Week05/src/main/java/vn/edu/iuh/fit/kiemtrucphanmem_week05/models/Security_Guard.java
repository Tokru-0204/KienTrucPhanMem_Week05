package vn.edu.iuh.fit.kiemtrucphanmem_week05.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Security_Guard")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Security_Guard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String userName;
    private String passWord;
    private String fullName;
    private int age;
    private String address;
    private long salary;

}
