   M S B A M L   `   `   `  ����I  EohFound_Client, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null/clr-namespace:ohFound_ClientohFound_Client  5      !    ohFound_Client.Aktivitäten   5      W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      .localclr-namespace:ohFound_Client     5      .��5	      � .+�5
   
   �� $��Aktivitäten-Überwachung��6   $
��Left=�62   $��	10,10,0,0q�6M   $	��Top=�6`   $	��334��6x   �� 5   
   -   5        $#��Verdächtigkeitsgrad erhöhen��5      $
��Left=�6N   $��
10,195,0,0q�6i   $	��Top=�6}   $	��186��6�   �� 5   
   -   5        $!��Verdächtigkeitsgrad senken��5      $
��Left=�6M   $��201,195,0,0q�6h   $	��Top=�6}   $	��185��6�   �� 5   
   $��Belastete Benutzer��6   $
��Left=�6-   $��
10,220,0,0q�6H   $	��Top=�6\   $	��289��6t   �� 5   
   -   5        $��Benutzerkonto sperren��5      $
��Left=�61   $��
10,364,0,0q�6L   $	��Top=�6`   $	��140��6x   $��22��6�   6�   �� 5   
   -   5        $��Fertig��5      $
��Left=�6"   $��695,380,0,0q�6=   $	��Top=�6R   $��75��6j   6u   &   System.Windows.Controls.DataGrid  5   
   -   5           Name$  dg_activity��5      $
��Left=�6@   $	��149��6[   $��	10,41,0,0q�6h   $	��Top=�6{   $	��732��6�      AutoGenerateColumns .  ��6(   ��    Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn   Header$ Activity ID��6%      
IsReadOnly . 1  +System.Windows.Controls.DataGridBoundColumn   Binding 6:   �� *Activity_id+6Z     5      $ Category��6%    .  67   �� *
Category+6T     5      $ 
Account ID��6%    .  69   �� *
Account_id+6X     5      $ Account name��6%    .  6;   �� *Account_name+6\   5        5   
   -   5        $  dg_accounts��5      $
��Left=�6@   $	��107��6[   $��
10,251,0,0q�6h   $	��Top=�6|   $	��732��6�    .  ��6(   ��  5        5      $ 
Account ID��6%    .  69   �� *
Account_id+6X     5      $ Username��6%    .  67   �� *
Username+6T     5      $ 	Firstname��6%    .  68   �� *	Firstname+6V     5      $ Lastname��6%    .  67   �� *
Lastname+6T     5      $ Organizationname��6%    .  6?   �� *Organizationname+6d     5      $ Locked��6%    .  65   �� *Locked+6P     5       $ Suspicion Level��6%    .  6>   �� *Suspicion_level+6b   5"      5$      5%      