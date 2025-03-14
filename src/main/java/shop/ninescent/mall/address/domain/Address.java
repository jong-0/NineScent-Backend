package shop.ninescent.mall.address.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.ninescent.mall.member.domain.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addrNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no", nullable = false)
    @JsonIgnore // 직렬화에서 무시 <-- hibernateLazyInitializer 에서
    private User user; // User와 연관 관계

    @Column(nullable = false)
    private String addrName; // 예: "집", "회사"
    @Column(nullable = false)
    private String addrContact;
    @Column(nullable = false)
    private Long addrZipcode;
    @Column(nullable = false)
    private String addrAddress;
    @Column(nullable = false)
    private String addrDetail;
    @Column(nullable = true)
    private String addrRequest; // 배송 요청 사항
    @Column(nullable = false)
    private Boolean isDefault; // 기본 주소 여부
    @Column(nullable = false)
    private Boolean isLiked; // 즐겨찾기 여부
    @Column(nullable = false)
    private Boolean isExtraFee; // 배송 추가비 여부
    @Column(nullable = true)
    private LocalDateTime lastUsed; // 마지막 사용 시간
}
