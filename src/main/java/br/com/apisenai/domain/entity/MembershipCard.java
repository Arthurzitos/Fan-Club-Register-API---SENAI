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
public class MembershipCard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "UserRegistration_id")
    private UserRegistration userRegistration; // Relacionamento com o cadastro do usuário

    private LocalDate joiningDate;
    private String cardNumber;
    private String photoUrl;
    private CardRequest.CardStatus cardStatus; // Status da carteirinha
}