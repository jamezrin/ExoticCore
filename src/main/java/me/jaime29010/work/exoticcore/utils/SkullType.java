package me.jaime29010.work.exoticcore.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

/**
 * An utility to get heads of all the mobs in minecraft without contacting with Mojang API
 * @author jaime29010
 */
public enum SkullType {
    BLAZE(EntityType.BLAZE, "Blaze Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTAyNTYwMDYsInByb2ZpbGVJZCI6IjY0MjQ4NTljNTk0NDQwNzdiZTllMzJiMTY0MjdjMTIwIiwicHJvZmlsZU5hbWUiOiIyMDkiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2YzYTE2NzM0OGZhY2U1YzcwY2Q2ZjIzZDYzMjE3ZWRjNDM4ZGViNTlmM2YwM2Q2YTU3MTdjNGQxZTc5YWY2In19fQ==",
            "kNiIzLVNE/NYk0E5m+0TSPc52tmRasCNKsejA89FzRKC1GNE0Glk58aFZxWntpjprzLVNTffOmcK2qFe59qgN6MPU6G7DcvtnV6arEro9x189P5Q6ecubwmcEYbSIwl/LFHa3Lf400t9fuW1mQdhfWKpyZRBaSTU37HAATDZjz2jL63vswe0nDsSE3tQHZgO7pr42VONwwyt/qTpzDN7vp1zqpEO++dt61zAezn7UzwGarZGqIL/bTSBsdJk3KSQgE61z6OM0w0EuyAAQIzO/7w8I+XtswHMiYChf0r+orPEKEd74nsJ8Yj1DLeH2zEe00p6yB26Nx3MbE+fq8g3sD9owd9KNAwlTyd6kNU9EWBPp//0avMXB1lCtjBvQCDb4UDAJnXErZC0LihgZhC2t9t+RWf39N91IEs7H8Z/RRN5+CpgyjZouGRSDTuz55nIPc5m1bnSnkBriKq5E28Xy7OoFbWJAqUIoRH28fRNdQyzvRWwUVwgAIo4KLyhYspQf5qsii1MEAKgM1IjCBO4pTA0eWFt2h4Zhpa8VJxwnrjCKTAYXIgeBz3x8ZP4qYXrp6CEIUMWPW6enmNfZYWzqh4lTihnFJpQWoNIHc+L9eQnTWeSNaAuhZ2GapXp+gLaRlk0LudjLTi9mpnrOEtIGxH9fk0ZAX4FxPTpArxmHLg="),
    CAVE_SPIDER(EntityType.CAVE_SPIDER, "Cave Spider Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTAyOTg5MzQsInByb2ZpbGVJZCI6ImRhNzQ2NWVkMjljYjRkZTA5MzRkOTIwMTc0NDkxMzU1IiwicHJvZmlsZU5hbWUiOiJJc2F5bGEiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzE1YzdlOTQzYjk4M2VmZmE4YmI4NzA3MjYwMjBiMWI4NWIyZGMzOWRlZTVlZTY4NTI5NWNlNGM4Nzk0ZWUyIn19fQ==",
            "i86SE7Y6udvi/qsRg0Y1mRToS87EAZi52d7CaNLgMlaR4keIN+MFT4pBRAPudMjm7un+y/o7bD9FUHLNl9XvCTByzm1ogC5yVJ1BcOvniBiiIz8eMOnpJ5WtFK9JUqLv3UcubgL8etX9BlzCsQyvA4MY9rKfQiPrr52UkELydglhmYf8Hu4Svq86Ci/SZthhxuvOka+2YNCmqvFpEUOn/w7SuXbKc8tG2TdNc9Zi3grTbAPW0NuuCo3PbOcPFSEdRVQKZ9RjWl7/YN/feFg2EBQl05vdVeVNdcJZGDyMh97qoUsS517+cUjiG7nEAEe3h88DiYSCRY/am3QnT4qGrN50O0u41OKbKxyeh8nXIuKaCQOTIZvoa4tFC60aDYuPDLUodaFZYuNwq/abJBob8/2jipbrUYJ5i4N7tA/yt0Mt70zQ9UXulnqNBkyZourPJBObCGAAKJWsIGa9nb/JGSB068WRj5qnEu284FhuB2nrEBq/HsS+4/3NpQKO0sHeygPp4xf2DPcL8KeGRvMGQ/GiGUrPApGF5i2J+AEmqenXwrM6X8QxbMeAeE6kXKTmcf93qtAhVWh7M4I7fPgW4nSS6Ca+KSz4Fo9Zj8EDbyv/jRga61Ksq1FoEJCw+t00wIgnspP8SlaO0E9prp9HWkFa/9MgkmgUQUoOvTig478="),
    CHICKEN(EntityType.CHICKEN, "Chicken Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTA0MjIxNTYsInByb2ZpbGVJZCI6IjQzYTgzNzNkNjQyOTQ1MTBhOWFhYjMwZjViM2NlYmIzIiwicHJvZmlsZU5hbWUiOiJTa3VsbENsaWVudFNraW42Iiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8yYTllNTZhMjU1OTU3N2U5ODVlYmMwY2NlMDMyZDZiM2VlYWNiMDg3ZmM3MzQxY2NmZjVkMzRkOGQxYTM0In19fQ==",
            "qP01s5M/mkvEleDWHy4tZ6mxYVQG9meDoucF6Zwj3fdsdglzXF/YOPSVhVoln6T5v+koEEPjuH9EjuZZrNxHhdVOvBAho5T2JMmif0oP5pjf+FPgxhS61xeVhWe1tPEsGskqQP+46BZoeTpZbfO+XgeOaszLqAidSewoQ8dKfluuxs2kijD56pMM9KEJiEGCj/zN07SVFUzu7C6vxfVv5P+xcXZii2A+b7kCePYRe6dfz9jfD8XkwRz6R4LOzXO80Afv8M/kMO0xlXI0J20KXUkX1VTfK92J0eT51KSiJM9IaPG6kURD1/llkyb/J+9vVySOT6eR7xyeClx/nZpISM5ITWsmtw9qwmDTc9UlSi0Zpbj5UhH1UBuLZTsxzKmKWED/aCzxAiq4CQhobKNP5+NGchvy8jNNPi+nUQiUJ5751KkFyr6cUwj0dhlg467aWZRw9MKnbT/SO5DLz8CA0lIONgC7PkFiVZq54EuSqqv/9dBRJ0zVMFabb9tKlhw3oEkdyH/LyC0XkikslFEval7OV8iSQMSUuEN3L++UMOGszwVsmJVuN7ebGr15A1l6Y7slr158eH+qr4OClcHV6RwifHqj+0AJoLtk4ZVRPumg/YsIB0PchBXgtV1rnH+/cD98Skyr4Ke6TGgIdOcSafYeZObJyYV/YYwkKgyJdD8="),
    COW(EntityType.COW, "Cow Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTA1MDUzMzksInByb2ZpbGVJZCI6ImIwZDRiMjhiYzFkNzQ4ODlhZjBlODY2MWNlZTk2YWFiIiwicHJvZmlsZU5hbWUiOiJJbnZlbnRpdmVHYW1lcyIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmE1MjViODc4NjFkOWVlYjc5MDIyMTY0MWQ0YzM5MDliZWNmOGMwODAyOWNhZmIyNWUxMjYxNGE5ODk0MTJhIn19fQ==",
            "J6HKgv3OxsJ/VPqEWoXZts+BH+VaBvnywrXJkpjYjBrAfwlIIe1s5hdoSnnTWbAIWjCyO0asriChOIaHDTpb6jZrLQ79syko9J1ox4XXGiuxR0jUC61nSfKtqpAlYe3mp5/3VLQZCYCekHGt3epEybPy/k82sMhYRIGmLkJ0WC8hXUDQxO7QgkFDFJyrRInJlAL9BBGCIDVCOLRCvOJgA2XQO7oZH9LrDY+Rk/Cl+QpPDb6N/XcusRgAoTNVFHuBuQI/8UyBcs8lFnfzkA3YTwvVlTDOdE0Y1z8Y5V4Rj8uX5Py5eMV/x+AnLrLY0hyrRA9SR5AlFbGBYLgXmEHHJv4+Owo3KZ+LsoLBE7JfC3iidohUIjqSD9RqSY52aJaHEbNFF7edTbepdQT7dTvGEYuiw6CD9b5+bWaI+tknIgLOvQQqkG4fwyHKQXI5ZCcygdN6x/rNJhHZeY7+7lo4tVqoBjNKfKoF0ysBU3sy1BPWUKptKUpLA7nmw2GBAH7LaSwtrhr7J0fkBvz0uZbUFbCl6fgjk1iDvKmAHHJgiKJ4Za7oPfpW9A/teExeVKcD8tiYjfQqDstPgcwKVvfzCfDJcY7QTADgqpEobwxSuuYW/vbNSfQxzI+a+2AKs7UFrOcmQIGR/I+Ap2ogwNmXqEqybtDoPSjiDzpdmX22RnM="),
    CREEPER(EntityType.CREEPER, "Creeper Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTAyMjU0OTYsInByb2ZpbGVJZCI6ImM5YjFmYTJiNjhkMjQ3N2U4NzgxYTYwNjMwMWIzMmFiIiwicHJvZmlsZU5hbWUiOiJBbnRob255OTE5MCIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjk1ZWY4MzYzODlhZjk5MzE1OGFiYTI3ZmYzN2I2NTY3MTg1ZjdhNzIxY2E5MGZkZmViOTM3YTdjYjU3NDcifX19",
            "l5DrkH76WcLT2vIa/eaeR2nyHX3LHFrT8XCJtCTwD/zZbWPcpVtpYEgEOkd21jPjjX3KVMe/OXI46zpcYzzOE0iZI5D0A9ObrynsWux1mdq/BraPNqzmb2zFaW6uUEy03coNVuYxgH0JgBnuWYne5HqLo1rllDiOzOAHm9CvJqQG2AEA8TdDdIGG1KSvQ0dUu3CTu2hC3G/0EVPXs3FMrutfxjz2n5gFIcCSNuWrvf9r/4Jcvn1AqA3KXHpIgDpMSJ6Z4Jk+UJgpG8q2DqW91osdnttqtxJjzE5uJKmfeDZvzoQX0MmC1zjSbcwSMxTlx3jWN2V4npVfm5lfWOEquGFQIViU37DcqsC3VNFLJRjZ1nRb8VBoQGImj6SEHtKydDLiBr1nmtk9/0s9RIyS35tZ8v43bPY84oxurWlQv7wml0gIWTKSQkO2j853DmxrqS2rolKJOTWlQml1QCmT34CwBvJOuLX8yQyjIVpRIIvB3/KG/iOzYS4R6MU/96a9pPvDHt3R4YIp0UT2NPqVc1IAXJw/nRX+InCRbKgfhe7Zb9ABY2O4+la0MmXNc0GbYUJVmtNpvM0RyiPLiY44CFX2Djd7qLkMP/0KS7SgwhHTayQRBFvn0/SNkMjNcX9GK9ePmS8h8FUnJ+kAD4BZdqKFYX86ldN8/mea68VhuAU="),
    ENDERMAN(EntityType.ENDERMAN, "Enderman Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTA2MjAxOTcsInByb2ZpbGVJZCI6IjNlMjZiMDk3MWFjZDRjNmQ5MzVjNmFkYjE1YjYyMDNhIiwicHJvZmlsZU5hbWUiOiJOYWhlbGUiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzc2YTIxZmNmOGM5NjViYmQ4NGM0MjU4YjI4ODY4OTUzM2RhZDU5ZDQ4YmQyYjdlY2I2OTIxZThiOGZhM2MzYyJ9fX0=",
            "jGdhCoxPGZc6EBTo8XczcBIVHenJGASGq3j+U6Qodw+qCMAnVCMHrb0bmDv7mPEBsJ0/d/drQhvF9CXV6maytlULXFRp0XaUISL1C0Zd7HarTzvel6UDyVv5IpzgJUeKLeQ8juOS6+asAksjb4y88Cw5Dyy+vPUPJOX8+WScMXWdB1DfUaWBf6jwmsVFvXqt577IcK9ILNRixGWWN43u57bmbKpv8rGX4SB9ZfcrCxzeJdVzkZhgArNjdL5wX9+C0Im/tM7yEEDacJTv5fIA09ZtczRbG2V6HdI+zMt3JnldCBXl4lBB7rBJOa98NXnwTuZ5uwDOf1RQCH2mbo7TrUUspd40YmOoC0p0mEpzkk21d6b/C5hFLKCssccyDHmB/tXJM/wN6QIMJsXFiwIajpHwcosLphlEIL0hd0KJelQOUTChZna/Xmn9WIr+rhd2yJWpFjWEeA9PVxrbDgX7rMn9ofTc71EAupsKsIVpMxQT72XnpB9ezcqfHGn9VpY1k26cluVD9Yg9L6weeLqixQ0hOAc9KadUZRbBbrcPWWmByrUBmRiWMBb30Qc7XyD19F6sXHNicoRfQ4fIgWYhuCnCquWn0ouvwindpUtjx7/Wb/pFuYceWAW5ALLHOMCpQZHjmbUOlv/NDLxvv/0ew4jtxdQmxbYEC1whzVSSfIE="),
    GHAST(EntityType.GHAST, "Ghast Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTI4OTc0MzMsInByb2ZpbGVJZCI6ImRhNzQ2NWVkMjljYjRkZTA5MzRkOTIwMTc0NDkxMzU1IiwicHJvZmlsZU5hbWUiOiJJc2F5bGEiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2ZmZDY4ODZmZjUxMzViYWNkYzdhMjFjOWRiZDI0MmMwZGNhNWIyOWJiYTIyYmFjY2E0MjdhZjA1NDM1ZGU5In19fQ==",
            "rd9YOwZBlDsPxJKh0tqY5+23c6d52fzzLdwZ3c/zIQlTVtn7EVd3OBZaObtB+Xpx8yxjVmmTc5bhV3YFrGraI66HyfG3osLGzTKeZHatSSHZ/ZHxsnU1acmii5RAzUbqWzKhBeCS10yOzut78v/Izn1xSrtsuPKjSyLtuCuV9y3l8O4QNlwgjlKS5w5Kr5m1B8V21ShL7QOXbkzZxzWUBYejeeO85Of7Lad10t+1Rokq6+5UEzaJUQH/YTm/fv+2hNF+iA9euaiZ1XP8Zx1V8gg7SWojvVMuWIcRq4LveXcag0+8bf2mmK1/oW/vyzUyHUWJ2Pk4mS92BYYO1h/qGQXNraV+7IKAbX75BOEL4I4MMjkx/30JlaHGrE8eg3H7HK1UgCagiaTgdKnrg0OVOSXIV66Rx8wHD0eiHdjvApqc5hbX+q5nMPCSihdm/GcW0BOti5nrxzkRkevC03eZzrUHaJ4j72H6naj//Iw3h2whqtpmuP+0UDSf9267hdZDI5SVi408usA6be2MRsglJBk4DxPNZJ9lKwTytZP8+UsfRmHvrz6iIncDP0LRXvvuco8tlZmBtuR2AzSpDvI6zC9iEfEhJNC1psjxdG87d4DDU6QtmrrleFBEA9lkMQTd5G7+l4llvX+5PjxWnejeq6DofK4KBwGRZj0+0Mp0SlI="),
    IRON_GOLEM(EntityType.IRON_GOLEM, "Iron Golem Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTI5MzQ4MDksInByb2ZpbGVJZCI6IjNlMjZiMDk3MWFjZDRjNmQ5MzVjNmFkYjE1YjYyMDNhIiwicHJvZmlsZU5hbWUiOiJOYWhlbGUiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2FlZWYzYTIzZWE1ZWNhYmUyZjFmZmIzN2I2MzNlZmU2NmQxZTVhN2Y2MmI1MDk4ZTY3MzQ2NGVhM2QxNzNlNSJ9fX0=",
            "rWrKQ1OXdZqKgA5P3e3OTRVwQMt4MyVrvM6JNkbAAlbnLcqhfdv6gS8UuhpXIWK5AHcZRTFj8GWiqeUOnV8IvArBOHmDsEJQ+SxJ0SGWw995PlalAcMopFkpMsKwUB1lkpKchWarOjhaUwMdin9+FKhl2TJ4Cm+QZaLvV3FgbzgUCiL8psmAl/cXwN9z33aDr/MxC2CKVBr0i4kaHBlwbQJ4PUT5PUAkHN09bxN29OkgQg5yyqfsMWjah9BLe7WzkSvX8VGr/uWEj6lvnG+KbjqTTupuoD1PQucjyz9o9rspUx71BUMPLq5+i90aDpdFnmEtYEw0Kg3oaf3hPaY8blFSuhtYYL+zeLod8MUi0demwKhHWdfZJQJVHUoAeiS46SBhD5tlCfVSPnZlHY2fwAo4fsgA1z11NWddeTCPdzvR4WmateLhxC6/OH/Vc+1NZ+bDf2iIUlzRcYc/mbF94Unc5pwIFLKCrZHmk0iovYjsUGtzSePSJPI/lUbeKXyq46VOI8IXbN/WEQSgtXMXXFt1XsXlFDVq5YzcTyCaJ/nk4e7TaSmb19/euS0nqkwsLlSuZ0KGpqZ6V63CxPTEZB+c7/CK5zhU4+oSjyK9dsZhcHSJxOVYbNOQZTwQ+GZok9xwnQZin/EfveNwikjfFDx88VzYOqol/NDoINqgH/g="),
    MAGMA_CUBE(EntityType.MAGMA_CUBE, "Magma Cube Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTI5NjExNTUsInByb2ZpbGVJZCI6IjQzYTgzNzNkNjQyOTQ1MTBhOWFhYjMwZjViM2NlYmIzIiwicHJvZmlsZU5hbWUiOiJTa3VsbENsaWVudFNraW42Iiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8xNWZmNjhlYzRmM2MxYWNkNGU5Njk3YTI0NTM2YjZhZjQ0ZWJjNzE2N2M0MzQxYWE0YmNjODA0MzM5ZjQxNzUwIn19fQ==",
            "gtQkoIwMI776i364JTartTARJX5US0MpFFE8iz/0d6zjGBVantLXcmhxaSWRHTp0KewUT4FNft9Q5aksQ+4v8vQkuE2/XyJZ6BSc5/f6GLE2BRjxbbA1F1iWKcgC85wKHULiiszRtuZgMEJQD3ya/amjuQaggu9JFyC21sTl6mJ1Kb16lZLnSVM8HL/mjDVKS64fyyATdK60vU3TlM9MKHMO9EXIfE6ODc10DZIVo71O+Sw+tFXuHlEs+j9EPTKPlGN/b9dtROJFoNUyeHiuSi05EGJe49JYI8S21Oz03ocAzBrvHAYh8g9GFYukQa1g1BtcQNibGD9DZKsmlCv3OLnXwzuOG6wntcrb+ygWqk36ibxyM5RlM4rIl+yl58l1Qykv/wqgZ8eASZYsGjyzDS22jDzXRyndR5JeIEJaUoavdaMy4Gk3rDykpiDaqKYn280FyNiFqUpdA2Yv6hMuL+aEIhp5zLCg5xNXptMXy4BzEpwnfiW8inKlnD9ehbVBzwmwTangC/zznF0weMgYwNr3176Z8cRFTLi72kFZP3UP7Iyg9k4j/5PZ8kCfPh+A5ORzEvPujYghJ+oOuhKsLTJlTa7kKuIKbIAS+wxYrwhfZy2W+MSS4ZvXkB7XVB0hCxapRgHyRDLtpfJg06PbXeLa0mCoh8qFuaJt3QBNJNc="),
    MUSHROOM_COW(EntityType.MUSHROOM_COW, "Mushroom Cow Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTI5ODg0NDQsInByb2ZpbGVJZCI6ImIwZDRiMjhiYzFkNzQ4ODlhZjBlODY2MWNlZTk2YWFiIiwicHJvZmlsZU5hbWUiOiJJbnZlbnRpdmVHYW1lcyIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGRkNGY1YmY3Y2JhNzhmNjEyYzMyN2U1YmI3ZmRlNGIzODM0OTI1MDQ3ZWQxOTQ3ODQ4NTQ1Yzk4MjNkMjgxNiJ9fX0=",
            "KWvMvkciN+AqWAsPA33vpy0nUTQLgAmAyMCN4W4M+ZK3HyT4k4zILZAQia5iJTZGdfy1WyzjTtDOYsedRsiju9CVUGUpAHjd9qWzhr6RdPJ+n2ZEUMeMapHbUQg6oFtkFiDXzJISr6GzhTtLonJJKdsoFWqPI2lmxoyeI8NX1niAeQeBEfWFK3rAGnaTgBoYcCDlPeh2VC8MUMcEAplbtxeH3qSxVnwQVHg8yvJgjW3Wip3PgPQQTxNiuauDbFrRLrp1K8grrPwf139hygPa/NM44RHiP8lbNj1IB2zwvQcMsQEOMn3+c1zXXrPO2DydXZ5FAOtCp+PH4qnoLMtgKtv3hKoEcc3TD/Al2/o3SwerNj5kpF72E/FYVPYkAV3LPb3kOrF0+GGJaUBLjqGKdavTF7S1rea4siWHU3UgBocOoMjTvy4n4sxvCyGZ1B/2maSEezXBvOXR0CPSXrTF8yhEx6nPwGxU4AcHJ7xCWPemdy3GOPoqaenwSk3AOAoArcOE1JgwM0ZOnXySSfgcZVkiku2LgF4sd3BhneKwWq1g06+GyWgoRmkRQR8iI2KEarfXEKrUg0tI2r3WB55Jw/OK7Nz2RLKp/yi1NV/WcF9h++qll3mgRUO5okh/bEeP6fsyKuGzZvAGID7rRIanGsv5+YZx3E0lvV3A/Je+9VA="),
    OCELOT(EntityType.OCELOT, "Ocelot Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTMwMTgyNzEsInByb2ZpbGVJZCI6ImM5YjFmYTJiNjhkMjQ3N2U4NzgxYTYwNjMwMWIzMmFiIiwicHJvZmlsZU5hbWUiOiJBbnRob255OTE5MCIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjI2NmFmZjU1NTE2NWFjMTY5YWU3ZjZkNGE2ZjE4ZTQ5NDQzYjY2ODgyZWRhZGE2M2ZmMWNkMDkzMTBkN2QzIn19fQ==",
            "A5jO1XA/nDTjqTVLVbXOGe8zaoyi7l/jpX66Gn353ByhGBaVCAc8qdoYpGEbux2PfA93xWfc+DA7ixNBqQjRZQ+hKr/IPLKPlMcd6t2PyszOVn4W3oAxplDvgrhWlChb9MY3iIBc7Ag+PDRUbgGgHxEf4YVmzAxxdtdzo3zJNBGyQ0szcXbTwYm1YnPinKG6BoY3vInQRJeyokyst/83YYJLUW9w85Za8Sqa1S9gUI1Y3aeqMbomMT7N+lshvNq9LACEz1MH0hyrqlSvxxOx7ihbXVgDJ8loOmu856Q87AcqHbEc6LZtB0dBnsacKFXp8OwHIDQwbfDRwC+l1wfUkzq6roc8CEBOEuNOOjJuXaa8yJEUly1XYD1YU64vSyqC5ZroUSFmTSOGhfO04DfiQoME7AfH+tO1efpiHouZ4I0sjEypKckmiEUbqieDWQB7FCk/y/+aSOboJZJsMNr8tb2tkBZnTk+ySvVg97VtbtrkH6AYxOzFEeimOSD3OVamPrAvxIVzwd2FYS3aQihr16BPPquEXuarW7CkWrR5rb9ajZp5XDzYwoHyqSTT1MDloqNX+D+Ws7HpqHJosHgM6V7WNZfkSVc8Dfv4xyA4OjEb38upXEuIUDQDyWaJgD1/VKSIJ9HpMkWPPzcnVJDXi9WLUjaF/S++vkb8NqSWQDw="),
    PIG(EntityType.PIG, "Pig Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTMwNTE5MTcsInByb2ZpbGVJZCI6IjY0MjQ4NTljNTk0NDQwNzdiZTllMzJiMTY0MjdjMTIwIiwicHJvZmlsZU5hbWUiOiIyMDkiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzIxYTEzZGE3NTU4ZmViZjc4NjFkYjA0MTM4NGUxNmM4MTU2ZDBjNWExN2RhZmMyYjlkNjc4ZThmZCJ9fX0=",
            "Vt41qNNKTIBOsnpJma+DLX5bdK46KvC1m+EUUZ3xZwhqiuAceLJEMIrA2BApbkswCLoze7zNWKVdD1WqbQPYJQr/Vh5B9DtIK4E7MkSLOcuaIomMf9OVAuqtCKomywiWhhDyCTx+xjjnG14VPIrt8ZgNl1OSEwKod3ARyzCxYPbtiUUBGOgCSS7vFkptoMhJi/12iL7TW+yAojHuJ/vJLOjrF2Q+e0kufj8IstvdzE64H5YLiBtXxDyOVMx/GOO9yvKvtg/cO/xHi5c+6AJGzwO3OYJ2FX1m2Tqx4l9BW0NTQscAyVMGFI7Keeg8JckWxvvJzlmiuS2uSUAp0W03PkpLYQ5YmrkC2SCho3uEE7MvMQbPgshH4fsHO9XlFgWWBnEfWfeGKhn3Qfn9M7SaTTyReAQbLqa2vBbXBCTm3JtzfyRjEwnTaLlXp3Hbask1rUPxFttbiyarztmpLnwpeiVwqenGc7TxC1uItNz/YmTx+Pinr9aL+atyqyB4MSVKyqJGQELUtGWoxqSbBt4wcW14GMS7PL3vaoXdx9ySYS25wm0e6/4GdC/z+b2FpeThZfowVo/AmVH4Qf+FHm6JAlDg+m8ZYZnfM3a2WhswpasUmjtk3eH+3kHQUFl1lqkcnkJ6S10/R1XcMKZXM4zJq1VDssY++UbvRgGJASK0kAg="),
    PIG_ZOMBIE(EntityType.PIG_ZOMBIE, "Zombie Pigman Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTMwNzUwNTIsInByb2ZpbGVJZCI6ImRhNzQ2NWVkMjljYjRkZTA5MzRkOTIwMTc0NDkxMzU1IiwicHJvZmlsZU5hbWUiOiJJc2F5bGEiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzE4YWViNWFjOTk5M2I0ZTFiM2YyMDQ0ZmI1ZjRjNmI4NTc2ODY0OTVjYzZhNmVhZTQyOGVkZDA0ZDI1Mjg5OCJ9fX0=",
            "uTU3ZroEldIdHHHBS8OBVbbHc3b0+rSUPSH29qPPeGmTqP8UslLRQwqTALES49Lwz+BbYfVanGuHgTWHqavUHFR5GKeB1P3dRnUvWTFoaSTDl4cGIaxoBqcWhfFAX5VzwsX+iq1snMzKawfkEx/8G8lsxN4RgoicCco+IlC2cyL7u+ScthqAJII3cyBCyLIQuTQ3Ekq3xouZI3XeD6EiejHyHBQtQlk1+b4aFFik7u2TId8UMvqrcjZyHC+h5Syop48Zx7gQ/I/DpRmnQ9/USflhfm+dfgMdQT6wo757XcFv4oWeosWdPwsdO/whAu655L79pETY2oGL9cpikENUpBwdMKY4HwgFrsy5YwvRPyMH0B3uyAXuZB/spo4E/vwlS/QmYgCPG1aYJAAu70LDqixJyoWmXQC0mohUha9/1wukbZXobz+mXoRY+/jIdIw7BEagpZPdehDxoUryFY2w8xnltvUXfZfzXEHQ9l8oLKuQAkbE2/xCEP1npXE3sSxt3GREOtHyDlfFLkCsAwzEut6DPzmBdDe5cyEstgKKJJqzuyCIrvUX2yFjX+P0xlkf6GuYmb9vPQ5W3V5P7o6sgP18bKvYiq+YBOmEzHjSunq7v90T6blTIloi2XADEBgsQTYKV5t19TrlkgVuSVh4lwsprtsGpi4BNelrc6naoUY="),
    SHEEP(EntityType.SHEEP, "Sheep Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTMwOTkxMjcsInByb2ZpbGVJZCI6IjNlMjZiMDk3MWFjZDRjNmQ5MzVjNmFkYjE1YjYyMDNhIiwicHJvZmlsZU5hbWUiOiJOYWhlbGUiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzdiMzhhZDQ2YTkxNTJkNjY5ODI0ZmI2MzJlZGIyZWYyOGRkNTc5ZTE1ZDRmOGYzNzNmYmZiYjgwNDQ1MyJ9fX0=",
            "Io/E37BMa445GPRtFTzXoPfYy1TwG0kSx2aAGPIAHelM683jTV396q3m5slfDQZmxJ5ToZsvlCOqhG+Zh3236weIgBOiFH2qm9/nL3aEqZ+b0W56qztuEjoX6dE9GgEZ+ctQoVgA2JQ+Xr3zjsrTDYdnEYFqUDRiBKRKQR2IX3iscVhcv3cTBYtWHu32ZGPb+LxeI7ghvMM0ABXcD0QVK3v2JJTkHxq2imzz24jUhqgl19httqePenZO410uSWEKQpq/dUJPczjRDiEeEzU0vQjnVpypmouJGEz/aYwaY94Q6N6BTz2m5y2jO0Mj12jFKumIisbcNZelIqMezDogLmyKHsWSp20zjTdmf/ziYziEB1p5JGoLM7Fy0tphtD8Fo2Ee28WHSFmKxHDUgTzufSBZa1IhxliVM+wsoq/ua4oVdO9Uh+RbZfqlV41dqwHKaOYJIkHM/yVM7+5SdnVN/bOOQnXQTmUXIaeOe3018SST8Bq+9+M6HT6NsO+HeTW45lw2jTd1dQ/njHqah9JLqxBYstFRmar5n5lneaeVRchc7x+MK2A0STXDoYnwHwY/hbFP8Gn4eJKbfpVb2iAe+Pvzh2xLMk1cjfcJ3SyymwcvNf7bH/nx7RNTVfnUMWQoc/WkrKoad1q0hVFC38MAZEObIIrPBN8jTmBodHlxujM="),
    SKELETON(EntityType.SKELETON, "Skeleton Skull",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTAwMTUxMTgsInByb2ZpbGVJZCI6IjQzYTgzNzNkNjQyOTQ1MTBhOWFhYjMwZjViM2NlYmIzIiwicHJvZmlsZU5hbWUiOiJTa3VsbENsaWVudFNraW42Iiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8yZTViZTZhM2MwMTU5ZDJjMWYzYjFlNGUxZDgzODRiNmY3ZWJhYzk5M2Q1OGIxMGI5Zjg5ODljNzhhMjMyIn19fQ==",
            "uoeQvdHLu1T8UlmZNAbKti1hY+kYH4b2Dy8JL5R363Go+Lun5B9GPZnGmP/HSU6awAGbszDGs5AQM1THNPm3PF6sD8Lzp0ebtoX+F6MaxQtrupj6vjSdAQ/ox0uExNRWgJoRcd7NjtPJHUYtuAbdqJQbzdKomPSkJEWNhCbU8hbJB21Q7sotZDBsc8P0uo4Xp+/dQ8SmX9XZ2dcDUglHN3ijee/EKL4JIMHoDITyEwn7NWad8XFWeQtHsIhl8eX1KDVxGf5BkbZLh7F8z/dMzgR23jfzNukNh8n5MEOT+QLxbyAUrqw1F2yAfDNa4u9tc6SGAyd4t+NvfwDu7IDinnZ7MfWVqsjJVEYRkTEmWq0eN6W4Ev9SvkD1QqAO7llYBoOdiydlEKCsP7AILpKz6Z1CL74yABvFnKgtaAQSK3vB2Mi7mxnlsB3OEE2dz80NCm/yCXp4vtCsc4rnbLun5vJ2AzhfUu12JZ3XTpmKAvvoAYOqxXxZ1PU/PVwfPnMPy98fA4zHVrYfQZgJYpr+49M2Z2VcSs9DapX6P3Ufb44o2e/BUI/6vUidTvEMYhDDXC4x6i5HJc7Tk+YIv+/pWWhZTQnReX8I/u9rN4ePGWbqQsDDknO5xOknX5cX2vGXJm4DP59PWqWR075Vu6Eowu+NNf99glvSkZ02ZolBGPg="),
    SLIME(EntityType.SLIME, "Slime Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTMxNTk0MTIsInByb2ZpbGVJZCI6IjQzYTgzNzNkNjQyOTQ1MTBhOWFhYjMwZjViM2NlYmIzIiwicHJvZmlsZU5hbWUiOiJTa3VsbENsaWVudFNraW42Iiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS81Y2M0YjI0YjRkMWY5MDIxMWI3NjEwYmIyNjRjY2UwODc4NmFkZDk0MGE4MmJkOTI5NzEyZjI0ZDc4MGJkMmMifX19",
            "KaI5HWdQx5Il2glKYC3UHirB3/v3ybbbL1C5WKMFCEh3LW3e+3hTcQgOCmrDN2sRDVMVrME6jfpFE7ViB74HcmjmSrMdSrYu0EQ8sn974xN/N+YJCtt6KwfLwYcu7PnuisIc4VQcA9sPG6S9CRYQLN9UtApejp1zZroY+dPvKPLg59xMH9fMGsPCH4QwCexLaStXs+JLDKccqtWy0Xvq5u8yNEP+PfGLvIR0UT9jfiCWFuxcVOCxSSqhzQq4NDAhb+bcDlwG7o8h4dHWBUSSOTYVT4pYlOUcMY/IcQ/+r5fJYdjLWbpHCiWsXGZetFZ9cR15E0uwNjg1lveSFYe2kWbhdtKwzM06fR8pSiMSCJhDC45qumiX/qSx7uqI5Yqn1WesTMzFEVoCYwU9gAfzxKXgsmI1gCe/km5j+01oVnf/84qRP/zFcEs7UpOLCAIAFiMSy6WlAgemW/ph12ochwgbgKE0tD1xYsxpc81/5HJjZLhuVQC+RNO2yDXC9YHRTJz/WLufw136nlDRJQ8opzL6eKJCdWBsjwa/HyoqPCJimRsg5yvsm8F33w5cyP+aDx66KlsKqJpKpJ+ZtjVY80YQiZuhRPt+4/NfEpYiOOoa4f8hMZflM0q40YYFTN6bbvfivM/zSYz/I7UKQ5iBbAVA7MdN98XgS7n23sWRvcw="),
    SPIDER(EntityType.SPIDER, "Spider Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTMxODQ5MjksInByb2ZpbGVJZCI6ImIwZDRiMjhiYzFkNzQ4ODlhZjBlODY2MWNlZTk2YWFiIiwicHJvZmlsZU5hbWUiOiJJbnZlbnRpdmVHYW1lcyIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzNmZDRlOTZmMjY4OTQxOTBjYTJjOGUyMTUwODJmZTE5MmZmMTdiYmI0NjQzMzJmN2VjYmZmYzhhYjczMiJ9fX0=",
            "ks5FF0jf9a+Npl7Kj8GXQT8iwRF9SWZVspmSCXZ4E1jON8+lEiBcRA29nr1Z0oP1Fg4oiEZf9n8thg5dU+PsC02m6UE+hqr/yYE/AFkw4qowrfIKXqwMy41fAAtciw0LWhdU4o6RqA4CQGGjQ7TpmVtzkGmU78CUf0DjdRmhuWXaS4k/LvtBzZ/NouA6L7DLRLZvtqY7G1Y56t3RkYukXgJO/9aeNeuAlBnhBqVFW/JW+nsnyMOiPGcxQNa6ud8eEtUqQGu2XcAwA9852KXXxB8QnsfnrGJc7kGEa+RtYs9A5gPGgEQjTKsyi4EpzKAucbeuAZ1xlHJwSZ+pSnaRPhEpDymRer7x1U29k9lP3wr6KBwSFkndXE/1KSyWN7IvEoSEw8xi0MI9IeMYzCJjgzuZZ7EsfeWCWyLGfAH/x+AMMBiI7k8BskRaiQj/BwQ+ciZdau+p4MMVje5yDuLMJAuCuj7kXVDzaoVcarSsMqX7goFrPk5et30IedPxlA2iQdDB9rHA5cyAmSKffol9EzZQINDwk650Lvtpus1goPwJIQerArSWPJLjntSVJ6q4QXSPhG84pGhRpWFRd4/ao2JS9mk3a8+47z3lUZ/4xFYDGWjIm8sjqK9+nGtLbVdTI9iqDhikdoPDiUnI4AzH7LlUBya3zbxc6h/ClLLZhI8="),
    SQUID(EntityType.SQUID, "Squid Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTMyNTczMDgsInByb2ZpbGVJZCI6ImM5YjFmYTJiNjhkMjQ3N2U4NzgxYTYwNjMwMWIzMmFiIiwicHJvZmlsZU5hbWUiOiJBbnRob255OTE5MCIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjYxMTVhYjQ0MjM4NTgwM2QzNjc2NjViY2JiMzg0NmZmZDY5ZTljZTJmNDlhMWVmNmRlMjU2ZGM2Yzk3MjllIn19fQ==",
            "mgzXXVEYkniH1PFCteAgtCHF4AFBor4mpu9g1YYfJWwZbTe8JWpM5/gp2wQHh0KStGh+b5wRwbB8CIXIxKOx7Sn1/kDEjd6cUDGM5WzLYTZ36+M/Ju05fsWkp8XlQkjkub2i5TqYyWI4tKyh8LdwX+V86WNg+0pMfNYHi21scpXpcMyZCDagEzGX6LOOAHekrLNF1m5wSHhxUJvgnkhXFR2PnUC2PtQsOxtMDFQZgeAQis4Wbh3itJTowLp8ofWS8cdpaGSL9KlH+qxmEcOhBb5nSCXWBKPyGk3Mp35TVZfg55Gaup2PxROhVrlPoqBTBAPzh6ojw40Di7j++TzppFPoAf8vSZAcc48t4Na29cVHLHVbMuuDSRdOz/86S32mz7i2v2ICk3orp44IuQMf2bXONzxNfsCiS7zTsD+E0Jtp9B2ijrtI2RQu//siEsMGZOFFgqmEtd51u7op7DC0hHkyI4KIwK4gIJ3k1m/d2N0s7kz9I12CdCx73Bz1zLzHDX8tQFiHPutzby13q2u1tbTtC1a4cvCh+/4U6PzP6fAP6zUTaXq+mI5slHAvn1RDO10dxf5rcuKB+M+7FaKnA69xFiy9XsYVY2dhB7wBikbLhZ8YTbALfi5cpG5nZQdV/vgQvXEB2VtbunyEk+4WHFaMCmmZpOXXO9sosZmPclI="),
    VILLAGER(EntityType.VILLAGER, "Villager Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTMzMDYzOTcsInByb2ZpbGVJZCI6IjY0MjQ4NTljNTk0NDQwNzdiZTllMzJiMTY0MjdjMTIwIiwicHJvZmlsZU5hbWUiOiIyMDkiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2I3Yjg5YjVkZDgyZGQ1ZTBkZjYxYjlkMDVjNWQ1YTNhZWU5ZmMwZjQzMmY2MmJjNTJlNTJiZGJkNTliNDJmNiJ9fX0=",
            "Hhd/lQs+FgwowZJuxWYd8WDD6TaSb7HTF56aA4S+qb7nNkX6Ogcx/BAUIxhBkPJaMk3/+U4LIqUzxQ1Er/kWyJbQcAsExG2S24eHQBDE8rEz8awks/MYdJ2Hg+aHlxUQ35Qzbxq0ff2BvRcd7TlQz+B2iz3gzyafMbB3JSg2LNu9UN3PCGG6r1/bC20z4BFCm6+2cUs9vLgFOiHucMkaQxh8IRkG2EIzC71bUNQyTWCNpqEGt7uRpbOIELUSFQl7H3EJhtIcSqYXZN+arjUwJ1fVEYdJIcgLJWNxxA+2AoDxe90B/sDt7DqCELyq3DQ9cEZJ8fUii87H0eAbKGimGDmDcVwQohTKqe8sgmZSGk2hy22WrmfG/NGNFsLyrZsLOyqBBLURwK3e3WCjPgf+f5hvMsgAkOgMsQPBFHcxkR71dj1gPJGzlbIAf0bi/0ZZQWFuE1nqWMsRVvdiR7pxmSkcPt7W4XcNUNKwnuDf+s+1o7hRgmGVQIjRbygPvSmzPUpWSi9AnVUoVQk02/8JMEDyPEHGkKPSX9Fw8WKoXhEgYNtTLzPaB5zazoQgrPkVUZVujAXP5tFpHImPiFhuNxHypyA0iOiXr5IpBpLrKTtAZVIEEcjLDNINpaL8oAp4pah94KRvPFFUL/rsIUhL4mS08fkF5Gj2HbqiNBNK8jM="),
    WITHER_SKELETON(EntityType.SKELETON, "Wither Skull",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTMzMzQ3NzAsInByb2ZpbGVJZCI6ImRhNzQ2NWVkMjljYjRkZTA5MzRkOTIwMTc0NDkxMzU1IiwicHJvZmlsZU5hbWUiOiJJc2F5bGEiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzIzM2I0MWZhNzljZDUzYTIzMGUyZGI5NDI4NjM4NDMxODNhNzA0MDQ1MzNiYmMwMWZhYjc0NDc2OWJjYiJ9fX0=",
            "HrHcs8D8j+RhJ6EA5vhUiPmsrWMe419sPmGLiXN8GDpy6KX7Ghrygj2rbmPBuNwhG4RF+agLzC9tD246ifX6jLAb1PeQVIs8v+sZ/wSkjAyeee/pskWjOr2W91GlgrNCrx/6XjGuMKQ9LxqHxEUE6TDbV53Fqr/1fZX7v+FzQUVOw1VboFH1rZA4T03qP3S/vap/clPrsGprzO+TBF28qZyhc3B6VJ55oUreOGGFYXAqWsDBpDeaesS0g3rB47jOBODujgVTqRjREMzmGgJZtzvtGSsU53kyE1RZ76CVIAPRQ5AnXqNPK/P2SThpOVbmpIa1IdDgSUiGKvxop6y9Px0HbUnYVqZU8aSVRnsK7CwTm+u9qZcz9r/uH15rko8SPBxqB9Ww2J+J2Qzw77d6zbxWl8kTRtYzQgaOPbIWkT3Q8QA+WtykcSjrsexGvV+XGLQh9ZLZcX3yw2ll++jYs8+F76rs/SCGfbYuUV9GabM9tJ/g/+uoZ98lydeAbKKzZ3LsQcxegomKWYKWxK/VKTfQ9vhTQeAq7tcSvoS9z3eVxeoLq5RPR6jQ9BgcoK4tiVHp1t9D0RcyHO9S9Kj+5OZA9nAxAcLiNnQWYEFs3yo0HUeaCPsuKpvO/TDVzGCZIftmVV/Gi0ZHwE6MtS2eW/mw2dRleunMdWVp4bT3mtw="),
    ZOMBIE(EntityType.ZOMBIE, "Zombie Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTAxMjg5MzAsInByb2ZpbGVJZCI6ImIwZDRiMjhiYzFkNzQ4ODlhZjBlODY2MWNlZTk2YWFiIiwicHJvZmlsZU5hbWUiOiJJbnZlbnRpdmVHYW1lcyIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTZmYzg1NGJiODRjZjRiNzY5NzI5Nzk3M2UwMmI3OWJjMTA2OTg0NjBiNTFhNjM5YzYwZTVlNDE3NzM0ZTExIn19fQ==",
            "jKHyruPNYLD68AUw2YxQyOS/vxsZ5hE2O2/S7HXkIGCvUGtXcfjebna5tHGoXTLo0DG+KXyJ4LiGtpnjBYXeuJPACxowyAzHnkzEzP9TRqgU8Vz7yfbYYl1aunCWYeHL6e4aO9UPISyrF9aSExJdr+2iyZJ0PBVPvrl3Sb82CP/wiyaiJfk+z2wK1yo7eceM75Xm1/SNYyGPteM+37y0x2NTAkfE7AFG9sClBHRgRwrJvzWBYzaZXGhq03FOLO7qYjv7/lndX2Ghlekc/pRh6O2Ao2P1LWpkWR93K6CiyNFE+Z7t+asrWIElxO7OlBaC8y4MBoafc37jTBp9MH6ZWXS9lDzSA+5bxgfE94okYJdzNuNz7Gb9bxiLaixuo8DnxEB0iiKbhy7o7rQRitiKdY9V8X22TMaaQcyise/W7ARude4qQiBf69nRGN4lJ+1BUEcBxm6jrbkn1OUEZdXl+dKurX6UsXlEMq1O+SglWRaZhnAIKUyPRvzbQXUpFiihbTCEIihCRhW/TIZIonXChKmSUA1nWamPKyX6NZISX1Cam7nCn7HJzjIFUsRtPvsVUThl6bKQzRePH0Fkk2gmGfa6wUV/lT4p0/RpuMzSmPAkITId8jLVKlSqxODMoqe4kQS+zCXzajFM4jmNISq/9Kw7LPwKF99mgyzX+Mz5jv8="),
    SILVERFISH(EntityType.SILVERFISH, "Silverfish Head",
            "eyJ0aW1lc3RhbXAiOjE0NjcyMTU2MzAwOTYsInByb2ZpbGVJZCI6IjNlMjZiMDk3MWFjZDRjNmQ5MzVjNmFkYjE1YjYyMDNhIiwicHJvZmlsZU5hbWUiOiJOYWhlbGUiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzZjNWQ0M2IzMmI2OGU2NWE2NDJjNjVjNjk0M2RkODhiOGU0YmEyYThjYWZmNjYyNzc0ZjA3N2IzYjg1ZSJ9fX0=",
            "dELMXGic707zy4wo5xORabXESLmWMBg8K1hWwRCmXukkJNVuDbRrhwiopVDExBxBFcPLrYplPva80TuCXgQchPwh/tt+8exyoHw0ZTf0hQjKdbnxHbyvqyA1zcPoY+sSghcF4/Q1lTYz8b3So89QQB9fmQc5ZPDt8zN8VK1GQzOl7x6at7rwgmQSC3hixrwmL1SY0EWzTiYUabCpkKkx0cAI2cPJosL4Iq5M3f99/kkytvUyd9Dn+Uj2wgqEz/2v2vJUs6vps+UZkTOWWTkV2M9NcbGFCbOXvo0YuyykuFLVBqS6My+E2j3YyaGI8WCkI7V6aALCDgtXUMfrR1cGquuVcUvnxjVJQEAy2I5XAIM1Lzc5+GnwaaeGmkSwKHnGjcRhbYNl62s4bo56gdPfJvAjYMbTSreeQLbfiAtz+THtKlzL69Nr8Y5JwwwBBVHObRd5q/hJw4nqcbaSX1dQgDe/bKbwEvKfkXIynaLsFJYmbU5KWQtSxSLUrc7hwcybqXiMCmZhHZCETJ3LPZNvidM+xnS6ZENLi0AzRnELLPYkVi+hmnW72wc8O+AIBUO4+j86HLJW8HHv7rBQZzqBwLdq7B3VYMyY08B2psHW/bl1R3oKXW12w+5RmBvGLnsuLB5T6bwXWCr+l/kg0HwQHCHu3EUhvWtgOtVqq6dnvf8="),
    WOLF(EntityType.WOLF, "Wolf Head",
            "eyJ0aW1lc3RhbXAiOjE0NjczMTA3MTMyNTgsInByb2ZpbGVJZCI6IjQzYTgzNzNkNjQyOTQ1MTBhOWFhYjMwZjViM2NlYmIzIiwicHJvZmlsZU5hbWUiOiJTa3VsbENsaWVudFNraW42Iiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8yNzY4Y2JkNTIxY2IxODViMjc2NzJjZTQzMGZjNDg1MGQ3NTk1YzZlODc3OGUwNzI3MWM5NTc5ZWQxZjVhZmI1In19fQ==",
            "YpSaQLRsd4MlZ3hClrJUul6VdVt10D+9ggulKCC9IjYU9/peDNVyq5ii2F5bpzOOlusjemld4iqJlzt9Biyk3tL9BMYNXjjnD8Kyx4cZexdENtOKY1ngGmCmCNMdwJwRNyS6FZopKel0OaUJLjznMXY0yidbCPpU4Lt/o/6fCb9DENBCpDNizjrLFxP6R8FVT/mPVmEihi/y7HgI2Du0SG/VaYQeZDAwF2Pvni74vxJfU/BDqU4vnETUyRSEUlNZqyRsMkN/PXzEwd60rooGfPU0B2RJN04y+I8jYO7WT3FqCmAHRdeqBAs6FbYhzevJP4SVJgcWofVeHu5N10JSeNBoZriJsciLyUDisc00NcRtohK0LIYpTI0jy+meXwow0g7PgCRlg1jmLZPsFU00VrzHSFiaWQ2aGeOfcU+XlfA37lwVb3Ua04Z4h9Nqjbntr/SUYsqjCgUgIWOVD3l+KP8Zycmfi6OcdIL102wi6wjOtgX6GtdeW0h6a2X2DLZlJoWxO1ZPjJaF1oIZiYbH1h5lfHxMVwGLE/NFfpcZpX9ZTpkmMk/jmjKgck1+su+6pyVhYt1rKdYdMjW9a17dXzoD5lLSnX0OMrxrGdBwW5AhhNkTtXmn8qPa4qMQ1cAtjMqBN1G0VjVl2MUVZzbHfiw/ompa9TFuwo/ZwcO5tWI=");
    private final EntityType type;
    private final String name;
    private final ItemStack item;
    private final GameProfile profile;

    SkullType(EntityType type, String name, String textures, String signature) {
        this.type = type;
        this.name = name;

        item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta meta = (SkullMeta) item.getItemMeta();

        if (name != null) {
            meta.setDisplayName(ChatColor.WHITE + name);
        }

        if (textures != null) {
            profile = new GameProfile(UUID.randomUUID(), null);
            profile.getProperties().put("textures", new Property("textures", textures, signature));

            try {
                Field field = meta.getClass().getDeclaredField("profile");
                field.setAccessible(true);
                field.set(meta, profile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            profile = null;
        }
        item.setItemMeta(meta);
    }

    public static SkullType from(EntityType type) {
        for (SkullType skull : values()) {
            if (skull.getEntityType() == type) {
                return skull;
            }
        }
        return null;
    }

    public static SkullType from(ItemStack item) {
        if (item.getType() == Material.SKULL_ITEM) {
            SkullMeta meta = (SkullMeta) item.getItemMeta();
            try {
                Field field = meta.getClass().getDeclaredField("profile");
                field.setAccessible(true);
                GameProfile profile = (GameProfile) field.get(meta);
                if (profile != null) {
                    String textures = getTextures(profile);
                    for (SkullType skull : values()) {
                        GameProfile other = skull.getGameProfile();
                        if (other != null) {
                            String value = getTextures(other);
                            if (value != null && value.equals(textures)) {
                                return skull;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static String getTextures(GameProfile profile) {
        PropertyMap properties = profile.getProperties();
        for (Property property : properties.get("textures")) {
            if (property.getName().equals("textures")) {
                return property.getValue();
            }
        }
        return null;
    }

    public EntityType getEntityType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public GameProfile getGameProfile() {
        return profile;
    }

    public ItemStack getItemStack() {
        return item;
    }
}
