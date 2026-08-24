# Omuzluk Modu (Forge 1.12.2)

Sağ ve sol omuz için ayrı, tamamen kozmetik omuzluk sistemi. 4 materyal (deri, demir, altın, elmas) × 2 taraf = 8 item.

## Neler var?

- **8 item**: `omuzluk_<materyal>_<sol|sag>` — sadece kendi tarafına takılabilir.
- **Envanterde ayrı bir yer**: Vanilla envanter ekranına (E tuşu) sağ üstte bir **"Omuzluk"** butonu eklenir. Butona basınca sol/sağ omuzluk slotlarının olduğu ayrı bir ekran açılır.
- Bu ekranda ayrıca senin ana envanterin de görünür, böylece omuzluğu doğrudan sürükleyip bırakabilirsin. Sol slot sadece `_sol` itemleri, sağ slot sadece `_sag` itemleri kabul eder.
- Takılan omuzluk karakterin üzerinde (basit, materyale göre renkli bir küp olarak) görünür — tamamen kozmetik, savaş/zırh değeri yoktur.
- Ölünce omuzluklar düşmez, karakterle birlikte kalır (capability sistemi ile saklanır).

## Nasıl derlenir (build)

1. Forge MDK 1.12.2 indir (bu proje `1.12.2-14.23.5.2860` sürümüne göre ayarlı).
2. Bu klasördeki dosyaları MDK'nın içine kopyala.
3. Terminalde:4. Test için: `./gradlew runClient`
5. Derlenen jar `build/libs/omuzluk-mod-1.0.0.jar` içinde çıkar.

## GitHub

Repo: https://github.com/Rowanle39-maker/omuzluk-mod

## Bilinen sınırlamalar / geliştirilebilecekler

- Karakterin üzerindeki omuzluk render'ı şu an basit bir küp — gerçek bir 3D model ile değiştirilebilir.
- Item ikonları basit, programatik üretilmiş placeholder resimlerdir.
- 1.12.2 için yazıldı; 1.16.5 veya 1.20.1'e taşımak istersen kapsamlı bir port gerekir.
