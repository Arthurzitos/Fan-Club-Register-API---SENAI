package br.com.apisenai.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id") // id do usuário
    private UserRegistration user;

    private LocalDate requestDate;
    private CardStatus cardStatus;
    public enum CardStatus {
        REQUEST,
        REQUESTED,
        PRODUCED,
        SENT
    }
}